package com.ycl.shop.start;

import java.io.IOException;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BootStart {
	
	public static void main(String[] args) {
		System.err.println("商品服务开始启动");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml","classpath:applicationContext-dao.xml");
		context.start();
		System.out.println("商品服务结束启动,可以使用");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
