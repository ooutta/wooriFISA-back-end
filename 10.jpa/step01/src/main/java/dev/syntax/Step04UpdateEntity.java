package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step04UpdateEntity {

	/*
	 * 엔티티 값(Java에서는 Entity 클래스의 필드, DB로 보면 컬럼)을 변경(수정)
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			
			Book book = manager.find(Book.class, 1);
			System.out.println(book);
			
			// JPA에서는 별도의 UPDATE를 위한 메서드를 제공하지 않음
			book.updateBookName("ABCD"); // Book의 이름을 JPA에서 ABC로 변경
			
//			manager.persist(book); // TODO : persist를 하지 않아도 변경 감지 발생
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
    
	}

}
