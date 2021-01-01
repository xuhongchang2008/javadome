package com.xhc.springcode.aspect.anno;

public class CustomerDaoImpl implements CustomerDao {

	public void save1() {
		System.out.println("保存客户...");
	}
	
	public void update() {
		System.out.println("修改客户...");
	}
	
}
