package dev.spring.step03constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		// 1. XML 파일을 사용하지만 Annotation이 적용되어 보다 간소화된 설정 방식
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation-config-constructor.xml");
		System.out.println(context);
		
		TapeReader reader = context.getBean(TapeReader.class);
		System.out.println(reader);
		
		reader.test();

		
	}

}
