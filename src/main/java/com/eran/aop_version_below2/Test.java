package com.eran.aop_version_below2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	//该包主要测试aop2.*以下的配置设置，该次针对spring aop2.0以下的配置实验失败，可能是spring包的问题，我导入的是2.0以上的包
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop_version_below2.xml");
		HelloWorld hwa = (HelloWorld)ctx.getBean("helloWorldImplA");
		hwa.printHelloWorld();
	}

}
