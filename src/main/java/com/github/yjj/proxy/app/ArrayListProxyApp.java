package com.github.yjj.proxy.app;

import java.util.ArrayList;
import java.util.List;

import com.github.yjj.proxy.handler.ArrayListHandler;


public class ArrayListProxyApp {

	public static void main(String[] args) {
		ArrayListHandler listHandler = new ArrayListHandler();
		@SuppressWarnings("unchecked")
		List<Integer> arrayListProxy = (List<Integer>) listHandler
				.bind(new ArrayList<Integer>());
		arrayListProxy.add(2);
		arrayListProxy.add(4);
		arrayListProxy.add(2);
		System.out.println("---- Iterator ----");
		for (int i : arrayListProxy) {
			System.out.print(i + "\t");
		}
	}

}
