package com.selin;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrintMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("消费者启动");
		while (true) { // 这里是一个死循环,目的就是让进程不退出,用于接收发布的消息
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
