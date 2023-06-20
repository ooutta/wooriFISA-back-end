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
		// 여기를 처음 실행하면 Student, Major 테이블 만들어준다.
		transaction.begin();
		
		Major major = new Major("컴퓨터 공학");
		manager.persist(major);
		
		Student kim = new Student("민수");
		kim.setMajor(major);
		manager.persist(kim);
		
		Student yoon = new Student("동열");
		yoon.setMajor(major);
		manager.persist(yoon);
		
		transaction.commit();
	}

	@Test
	void testRead() {
		// id가 1인 학생 엔티티 조회
		Student student = manager.find(Student.class, 1);
		System.out.println(student);
		
		Major major = student.getMajor();
		System.out.println(major);
		
		System.out.println("전공 이름 : " + major.getMajorName());
	}

	@Test
	void testUpdateRelation() {
		transaction.begin();
		
		// 새로운 전공 국문학과 생성
		Major major = new Major("국문학과");
		manager.persist(major);
		
		// 학번이 1인 학생(민수)의 전공을 국문학과로 변경
		Student student = manager.find(Student.class, 1);
		student.setMajor(major);
		
		transaction.commit();
	}

	@Test
	void testDeleteEntity() {
		// 국문학과 제거
		transaction.begin();
		
		Student student = manager.find(Student.class, 1);
		student.setMajor(null);
		
		Major major = manager.find(Major.class, 4);
		manager.remove(major);
		
		transaction.commit();
	}

}
