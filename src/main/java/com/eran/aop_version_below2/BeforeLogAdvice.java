package com.eran.aop_version_below2;

public class BeforeLogAdvice{

	public void before(){
		beforeLog();
	}
	
	private void beforeLog() {
		System.out.println("前置增强");
	}

}
