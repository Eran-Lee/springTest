package com.eran.aop.above2_annotation;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldImplA implements HelloWorld {

	public void printHelloWorld() {
		System.out.println("Enter HelloWorldImplA.printHelloWorld");
	}

	public void doPoint() {
		System.out.println("Enter HelloWorldImplA.doPoint");
	}

}
