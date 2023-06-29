package dev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.summer.Drink;

public class MyRoom {

	public static void main(String[] args) {
		// XML�� �ڼ��ߴ� <context:component-scan base-package="dev.spring" />�� ��ü�ϱ� ���� ���ڰ�
//		ApplicationContext context = new AnnotationConfigApplicationContext("dev.spring");
//		System.out.println(context);
//		
//		
//		TapeReader reader = context.getBean(TapeReader.class);
//		System.out.println(reader);
//		
//		reader.test();

		
		
		ApplicationContext context = new AnnotationConfigApplicationContext("dev.summer");
		Drink drink = context.getBean(Drink.class);
		System.out.println(drink);
	}

}
