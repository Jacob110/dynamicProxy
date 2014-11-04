package com.github.yjj.proxy.app;

import com.github.yjj.proxy.dao.DaoImpl;
import com.github.yjj.proxy.dao.IDao;
import com.github.yjj.proxy.handler.LogHandler;

public class ProxyTest {

	public static void main(String[] args) {
		LogHandler handler = new LogHandler();
		IDao dao = (IDao) handler.bind(new DaoImpl());
		dao.sayHello("Andy");
		dao.save("001", "Jimmy", "123");

	}

}
