package dev.syntax;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Step01CreatingEntityManager {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();
		
		System.out.println(manager); // �Ŵ��� ����, ���Ӽ� ���ؽ�Ʈ�� ������
		
//		// ����ü�� Ÿ������ ���� ���
//		ArrayList<String> list = new ArrayList<>();
//		
//		// �������̽��� ���
//		List<String> list2 = new ArrayList<>();
    
	}

}
