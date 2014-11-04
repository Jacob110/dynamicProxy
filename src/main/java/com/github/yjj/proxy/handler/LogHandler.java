package com.github.yjj.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogHandler implements InvocationHandler {

	private Object proxyObject;

	/**
	 * 绑定委托对象，并返回一个代理类
	 */
	public Object bind(Object proxyObject) {
		// TODO Auto-generated constructor stub
		this.proxyObject = proxyObject;
		// Proxy类是专门完成代理的操作类，可以通过此类为一个或多个接口动态地生成实现类
		// 要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
		return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(),
				proxyObject.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("......." + method.getName() + "..........执行");
		// 执行方法
		if (method.getName().startsWith("save")) {
			System.out.println(".....开启事务.....");
		}
		Object result = method.invoke(proxyObject, args);
		if (method.getName().startsWith("save")) {
			System.out.println(".....提交事务.....");
		}
		System.out.println("......." + method.getName() + "..........结束");
		return result;
	}

}
