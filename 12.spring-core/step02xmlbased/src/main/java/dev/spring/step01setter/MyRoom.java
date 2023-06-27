package dev.spring.step01setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		// ���������� �������ִ� ���丮�� TapeReader�� ���� ������(�ν��Ͻ�)�� ���Թ޾ƾ���
		
		
		// �ؾ��� ��
		// 1. ���������� �������ִ� ������ �����̳�(���丮) ����
		
		// 2. �����̳ʿ��� ���α׷� ���� �� ����� ��(Bean)���� � �͵��� �ִ��� ����
		
		// ���������� �������ִ� �ڵ�
		ApplicationContext context = new ClassPathXmlApplicationContext("setter-config.xml");
		
		// TapeReader ����
		TapeReader reader = context.getBean(TapeReader.class);
//		System.out.println(reader);
		
		Tape tape = context.getBean(Tape.class);
		
		reader.test();
		
		
	}

}
