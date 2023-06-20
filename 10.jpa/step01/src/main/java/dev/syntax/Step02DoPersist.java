package dev.syntax;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step02DoPersist {

	public static void main(String[] args) {
		
		// JPA 인터페이스에서(java.persistence) 제공하는 EntityManagerFactory에
		// Persistence 클래스로 하이버네이트 구현체를 인스턴스화
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			
			// Book 엔티티 생성, manager.persist(book) 시점까지는 transist 상태(비영속)
			// 영속화 되어있지 않음
			// 영속화(persist) : 영속성 컨텍스트에서 관리되고 있지 않은 상태
			Book book = new Book("JPA", "무명", new Date());
			
			manager.persist(book); // 영속화 진행. insert 할 때만 사용해주면 된다.
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
    
	}

}
