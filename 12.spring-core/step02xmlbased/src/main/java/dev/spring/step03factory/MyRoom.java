package dev.spring.step03factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		// 직접 작성한 커스텀 메서드 기반 주입
		ApplicationContext context = new ClassPathXmlApplicationContext("factory-config.xml");
		
		TapeReader reader = context.getBean(TapeReader.class);
		
		reader.test();

		
	}

}
