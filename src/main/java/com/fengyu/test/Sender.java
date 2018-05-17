package com.fengyu.test;

import java.io.IOException;
import java.util.Date;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender{

	@Scheduled(cron="0/5 * * * * ?")
	public void sender() throws IOException {
		
		try {
			InitialContext context = new InitialContext();
			
			Queue queue = (Queue)context.lookup("java:comp/env/queue/queue0");
			
			QueueConnectionFactory conFactory = (QueueConnectionFactory)context.lookup("java:comp/env/queue/connectionFactory");
		
			QueueConnection connection = (QueueConnection)conFactory.createConnection();
			
			QueueSession queueSession = connection.createQueueSession(false, Session.DUPS_OK_ACKNOWLEDGE);
			
			QueueSender sender = queueSession.createSender(queue);
			
			sender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			TextMessage message = queueSession.createTextMessage("Hello World" + new Date().getTime());
			
			sender.send(message);
			
			System.out.println("我在发送");
			
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
