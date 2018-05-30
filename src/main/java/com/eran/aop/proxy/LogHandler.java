package com.eran.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogHandler implements InvocationHandler {
	//目标对象
	private Object targetObject;
	
	public Object createProxy(Object targetObject) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
										targetObject.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = null;
		beforeLog();
		obj = method.invoke(targetObject, args);
		afterLog();
		return obj;
	}
	
	private void beforeLog() {
		System.out.println("开始执行");
	}
	
	private void afterLog() {
		System.out.println("执行完毕");
	}

}
