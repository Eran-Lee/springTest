package com.eran.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		//测试环境是spring 2.0以上xml形式
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		HelloWorld hwa = (HelloWorld)ctx.getBean("helloWorldImplA");
		HelloWorld hwb = (HelloWorld)ctx.getBean("helloWorldImplB");
		hwa.printHelloWorld();
		System.out.println();
		hwa.doPoint();
		
		System.out.println();
		hwb.printHelloWorld();
		System.out.println();
		hwb.doPoint();
		
	}

}
