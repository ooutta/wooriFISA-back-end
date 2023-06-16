package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Cafe;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("practice");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
//			transaction.begin();
//			Cafe cafe = new Cafe("아이스카페라떼", 3000);
//			manager.persist(cafe);
//			transaction.commit();
			
			Cafe result = manager.find(Cafe.class, 4);
			System.out.println(result);

			transaction.begin();
			manager.remove(result);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
	}

}
