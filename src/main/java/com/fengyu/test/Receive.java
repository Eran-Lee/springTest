package com.fengyu.test;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Receive{

	@Scheduled(cron="0/10 * * * * ?")
	public void receive() throws IOException {
		
		try {
			InitialContext context = new InitialContext();
			
			Queue queue = (Queue)context.lookup("java:comp/env/queue/queue0");
			
			QueueConnectionFactory conFactory = (QueueConnectionFactory)context.lookup("java:comp/env/queue/connectionFactory");
		
			QueueConnection connection = (QueueConnection)conFactory.createConnection();
			
			QueueSession queueSession = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			QueueReceiver receiver = queueSession.createReceiver(queue);
			
			connection.start();
			
			TextMessage message = (TextMessage)receiver.receive();
			
			System.out.println("接受消息：" + message);
			
			connection.close();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
