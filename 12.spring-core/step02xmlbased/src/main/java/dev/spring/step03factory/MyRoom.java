package dev.spring.step03factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		// ���� �ۼ��� Ŀ���� �޼��� ��� ����
		ApplicationContext context = new ClassPathXmlApplicationContext("factory-config.xml");
		
		TapeReader reader = context.getBean(TapeReader.class);
		
		reader.test();

		
	}

}
