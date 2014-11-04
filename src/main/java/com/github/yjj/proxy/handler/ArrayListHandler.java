package com.github.yjj.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

public class ArrayListHandler implements InvocationHandler {

	private Object target;

	public ArrayListHandler() {
		super();
	}

	public ArrayListHandler(Object target) {
		this.target = target;
	}

	/**
	 * bind pass object, return proxy object
	 */
	public Object bind(Object proxyObject) {
		this.target = proxyObject;
		Object proxyTarget = Proxy
				.newProxyInstance(proxyObject.getClass().getClassLoader(),
						proxyObject.getClass().getInterfaces(), this);
		return proxyTarget;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		long beginTime = System.currentTimeMillis();
		TimeUnit.MICROSECONDS.sleep(1);
		// execute actual method
		Object obj = method.invoke(target, args);
		long endTime = System.currentTimeMillis();
		if (method.getName().startsWith("add")) {
			System.out.println("[" + method.getName() + "]"
					+ args[0].toString() + " to " + proxy.toString());
		}
		// print executed times of method
		if (!method.getName().startsWith("toString")) {
			System.out.println("[" + method.getName() + "] spend "
					+ (endTime - beginTime) + " ms");
		}
		return obj;
	}

}
