package com.github.yjj.proxy.dao;

public class DaoImpl implements IDao {

	public void findById(String id) {
		System.out.println("findById : " + id);
	}

	public void save(String id, String name, String pwd) {
		System.out.println("save : id = " + id + "\tname = " + name
				+ "\tpwd = " + pwd);
	}

	public void sayHello(String name) {
		System.out.println("sayHello : " + name);
	}

}
