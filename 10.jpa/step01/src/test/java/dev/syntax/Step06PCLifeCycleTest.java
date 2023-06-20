package dev.syntax;
import dev.syntax.model.Book;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;


class Step06PCLifeCycleTest {

	// 테스트를 위한 기본 구성
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
	
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
		
	@Test
	void testPersist를_수행할_경우_엔티티가_영속화되고_commit이_수행될_경우_DB에_저장된다() {
		transaction.begin();
		
		Book jpaBook = new Book("JPA", "무명", new Date());
		manager.persist(jpaBook);
		
		transaction.commit();
		
		Book foundBook = manager.find(Book.class, jpaBook.getId());
		
		System.out.println(jpaBook == foundBook);
		assertEquals(jpaBook, foundBook);
	}

	@Test
	void test한번_영속화된_엔티티는_다시_조회시_DB가_아닌_영속성컨텍스트에서_조회된다() {
		int id = 1;
		// persistence.xml에서 create를 update로 수정하기
		
		Book foundBook = manager.find(Book.class, id);
		System.out.println(foundBook);
		
		// PC에 있으므로 DB에 가지 않는다.
		Book foundBookTwice = manager.find(Book.class, id);
		
		assertEquals(foundBook, foundBookTwice);
	}

	@Test
	void test엔티티의_값을_수정하고_commit하면_변경감지가_발생되어_UPDATE쿼리가_수행된다() {
		transaction.begin();
		Book book = manager.find(Book.class, 1);
		book.updateBookName("TEST");
		transaction.commit();
		
		Book updateBook = manager.find(Book.class, 1);
		assertEquals(book.getName(), updateBook.getName());
	}

	@Test
	void test만약_엔티티를_detach할경우_필드의_값을_변경해도_UPDATE쿼리가_수행되지_않는다() {
		int id = 1;
		transaction.begin();
		
		// id가 1번인 엔티티 조회
		Book foundBook = manager.find(Book.class, 1);
		foundBook.updateBookName("XYZ");
		
		manager.detach(foundBook); // foundBook 엔티티를 PC에서 분리(detach)
		// update 쿼리 수행 안됨
		
		transaction.commit(); 
		
		Book foundBookTwice = manager.find(Book.class, id);
		assertNotEquals(foundBook, foundBookTwice);
	}

	@Test
	void testRemove를_수행할경우_PC와_DB에서_데이터가_제거된다() {
		int id = 1;
		transaction.begin();
		Book foundBook = manager.find(Book.class, id);
		manager.remove(foundBook);
		
		transaction.commit();
		
		assertThrows(NullPointerException.class, () -> { // In Java, Thin Arrow(() -> {})
			
			// 위에서 remove가 되었기 때문에 select를 보내도 존재하지 않고, null이 할당됨
			Book foundBookTwice = manager.find(Book.class, id);
			// null.updateBookName()을 수행했기 때문에 nullPointer 발생(테스트 성공)
			foundBookTwice.updateBookName("Effective Unit Testing");
			
			// PC에 남아있으면 SELECT를 수행하지 않기 때문에 기존에 있던 엔티티와 비교 시 true가 나올 것
			
			// 'foundBook == foundBookTwice 조건의 결과가 false일 것이다'라는 단정문
			assertFalse(foundBook == foundBookTwice);
		});
	}

	@Test
	void test영속성컨텍스트를_초기화할경우_모든_엔티티가_제거됨() {
		int id = 2;
		
		Book foundBook = manager.find(Book.class, id);
		
		manager.clear(); // PC를 청소. 모든 엔티티 제거.
		
		Book foundBookTwice = manager.find(Book.class, id);
		
		assertFalse(foundBook == foundBookTwice);
	}

	@Test
	void test엔티티매니저가_제거됨() {
		EntityManager beforeClose = manager;
		System.out.println(manager); // SessionImpl(1202929159<open>)
		
		manager.close();
		
		EntityManager afterClose = manager;
		
		assertEquals(beforeClose, afterClose);
		
		System.out.println(manager); // SessionImpl(1202929159<closed>)
	}

}
