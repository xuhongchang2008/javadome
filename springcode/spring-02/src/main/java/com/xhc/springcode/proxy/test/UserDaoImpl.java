package com.xhc.springcode.proxy.test;

public class UserDaoImpl implements UserDao {

	public void save() {
		System.out.println("保存用户...");
	}
	
	public void update() {
		System.out.println("修改用户...");
	}

}
