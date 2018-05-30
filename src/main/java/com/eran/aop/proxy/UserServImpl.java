package com.eran.aop.proxy;

import java.util.List;

public class UserServImpl implements IUserServ {

	public List<User> findAllUser() {
		System.out.println("*********执行删除方法*********");
		return null;
	}

	public int deleteUserById(User user) {
		System.out.println("*********执行查询方法*********");
		return 0;
	}

	public int saveUser(User user) {
		System.out.println("*********执行添加方法*********");
		return 0;
	}

}
