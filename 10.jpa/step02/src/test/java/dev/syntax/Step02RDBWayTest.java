package dev.syntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dev.syntax.model.Major;
import dev.syntax.model.Student;

class Step02RDBWayTest {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
	
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
		
	
	@Test
	void testSave() {
		// ���⸦ ó�� �����ϸ� Student, Major ���̺� ������ش�.
		transaction.begin();
		
		Major major = new Major("��ǻ�� ����");
		manager.persist(major);
		
		Student kim = new Student("�μ�");
		kim.setMajor(major);
		manager.persist(kim);
		
		Student yoon = new Student("����");
		yoon.setMajor(major);
		manager.persist(yoon);
		
		transaction.commit();
	}

	@Test
	void testRead() {
		// id�� 1�� �л� ��ƼƼ ��ȸ
		Student student = manager.find(Student.class, 1);
		System.out.println(student);
		
		Major major = student.getMajor();
		System.out.println(major);
		
		System.out.println("���� �̸� : " + major.getMajorName());
	}

	@Test
	void testUpdateRelation() {
		transaction.begin();
		
		// ���ο� ���� �����а� ����
		Major major = new Major("�����а�");
		manager.persist(major);
		
		// �й��� 1�� �л�(�μ�)�� ������ �����а��� ����
		Student student = manager.find(Student.class, 1);
		student.setMajor(major);
		
		transaction.commit();
	}

	@Test
	void testDeleteEntity() {
		// �����а� ����
		transaction.begin();
		
		Student student = manager.find(Student.class, 1);
		student.setMajor(null);
		
		Major major = manager.find(Major.class, 4);
		manager.remove(major);
		
		transaction.commit();
	}

}
