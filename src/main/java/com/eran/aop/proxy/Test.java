package com.eran.aop.proxy;

public class Test {
	public static void main(String[] args) {
		LogHandler handler = new LogHandler();
		IUserServ iuserServ = (IUserServ)handler.createProxy(new UserServImpl());
		iuserServ.deleteUserById(new User());
	}
}
