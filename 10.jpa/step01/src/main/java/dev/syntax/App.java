package dev.syntax;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class App {

	public static void main(String[] args) {
		
		/*
		 * Persistence unit: EntityManager에 의해서 관리되는 모든 Entity
		 * 
		 * Entity: JPA가 관리하는 Java 객체(클래스)이자 DB 상에서는 테이블과 맵핑
		 * 
		 * EntityManagerFactory: EntityManager를 생성할 수 있는 Factory(공장)
		 * 
		 * EntityManager: Entity를 관리해주는 관리자
		 * 
		 * EntityTransaction: 데이터에 대한 변경(UPDATE, DELETE, INSERT) 작업이 필요할 때 사용되는 객체
		 * SELECT는 필요 x
		 * COMMIT을 수행할 때만 쿼리가 한 번에 적용될 수 있도록(쓰기 지연) 기능 제공
		 * 
		 * Persistence Context: 영속성 컨텍스트
		 */
		
		/*
		 * EntityManager을 생성하기 위한 객체
		 * Persistence unit인 persistence.xml 파일에 의해 설정 정보가 적용됨
		 */
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
		
		// Factory를 통해서 EntityManager 생성
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		/*
		 * 기존에 Book 테이블을 만들기 위해서는 직접 CREATE TABLE book 으로 작성했음
		 * JPA를 활용할 경우, Book이라는 이름의 클래스를 생성한 다음, 
		 * 테이블의 컬럼으로 맵핑될 수 있는 몇 가지 정보를 작성하면 자동으로 그 정보에 맞게 테이블이 생성됨
		 */
		
		try {
//			transaction.begin();
			// 아래 두 줄이 하나의 transaction이다.
			// Book 객체 생성
//			Book book = new Book("원피스", Date.valueOf("1995-05-21"));
//			manager.persist(book);
//			transaction.commit();
			
			// 실행하면 에러 발생 Book 클래스의 기본 생성자 만들기
			// Book data 조회: SELECT ~, 데이터 조회 작업 transaction 작업이 필요 없음
			Book result = manager.find(Book.class, 1);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close(); // 내부적으로 Connection 객체를 반납함
			factory.close();
		}
		
	}

}
