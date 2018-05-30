package com.eran.aop_version_below2;

public class AfterLogAdvice{

	
	private void afterLog() {
		System.out.println("后置增强");
	}

	public void afterReturning(){
		afterLog();
	}

}
