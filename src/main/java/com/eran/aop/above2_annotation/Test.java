package com.eran.aop.above2_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		//测试环境是spring 2.0以上annotation形式,实验失败，准备修改吧！
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop_version_above2_annotation.xml");
		HelloWorld hwa = (HelloWorld)ctx.getBean("helloWorldImplA");
		hwa.printHelloWorld();
	}
}
