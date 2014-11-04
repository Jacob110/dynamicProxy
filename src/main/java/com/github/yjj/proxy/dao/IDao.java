package com.github.yjj.proxy.dao;

public interface IDao {
	public void sayHello(String name);

	public void save(String id, String name, String pwd);

	public void findById(String id);
}
