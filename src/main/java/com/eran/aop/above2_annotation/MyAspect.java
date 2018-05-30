package com.eran.aop.above2_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	//前置增强
	@Before("execution(* com.eran.aop.abover2_annotation.HelloWorld.*(..))")
	public void before() {
		System.out.println("前置增强");
	}
	
	//后置增强
	@AfterReturning(value="execution(* com.eran.aop.abover2_annotation.HelloWorld.*(..))",returning = "returnVal")
	public void after() {
		System.out.println("后置增强");
	}
	
	   /**
     * 环绕通知
     * @param joinPoint 可用于执行切点的类
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.eran.aop.abover2_annotation.HelloWorld.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前....");
        Object obj= (Object) joinPoint.proceed();
        System.out.println("环绕通知后....");
        return obj;
    }
    
    /**
     * 抛出通知
     * @param e
     */
    @AfterThrowing(value="execution(* com.eran.aop.abover2_annotation.HelloWorld.*(..))",throwing = "e")
    public void afterThrowable(Throwable e){
        System.out.println("出现异常:msg="+e.getMessage());
    }

    /**
     * 无论什么情况下都会执行的方法
     */
    @After(value="execution(* com.eran.aop.abover2_annotation.HelloWorld.*(..))")
    public void after1(){
        System.out.println("最终通知....");
    }
}
