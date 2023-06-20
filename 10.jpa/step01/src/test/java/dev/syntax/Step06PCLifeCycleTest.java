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

	// �׽�Ʈ�� ���� �⺻ ����
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
	
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
		
	@Test
	void testPersist��_������_���_��ƼƼ��_����ȭ�ǰ�_commit��_�����_���_DB��_����ȴ�() {
		transaction.begin();
		
		Book jpaBook = new Book("JPA", "����", new Date());
		manager.persist(jpaBook);
		
		transaction.commit();
		
		Book foundBook = manager.find(Book.class, jpaBook.getId());
		
		System.out.println(jpaBook == foundBook);
		assertEquals(jpaBook, foundBook);
	}

	@Test
	void test�ѹ�_����ȭ��_��ƼƼ��_�ٽ�_��ȸ��_DB��_�ƴ�_���Ӽ����ؽ�Ʈ����_��ȸ�ȴ�() {
		int id = 1;
		// persistence.xml���� create�� update�� �����ϱ�
		
		Book foundBook = manager.find(Book.class, id);
		System.out.println(foundBook);
		
		// PC�� �����Ƿ� DB�� ���� �ʴ´�.
		Book foundBookTwice = manager.find(Book.class, id);
		
		assertEquals(foundBook, foundBookTwice);
	}

	@Test
	void test��ƼƼ��_����_�����ϰ�_commit�ϸ�_���氨����_�߻��Ǿ�_UPDATE������_����ȴ�() {
		transaction.begin();
		Book book = manager.find(Book.class, 1);
		book.updateBookName("TEST");
		transaction.commit();
		
		Book updateBook = manager.find(Book.class, 1);
		assertEquals(book.getName(), updateBook.getName());
	}

	@Test
	void test����_��ƼƼ��_detach�Ұ��_�ʵ���_����_�����ص�_UPDATE������_�������_�ʴ´�() {
		int id = 1;
		transaction.begin();
		
		// id�� 1���� ��ƼƼ ��ȸ
		Book foundBook = manager.find(Book.class, 1);
		foundBook.updateBookName("XYZ");
		
		manager.detach(foundBook); // foundBook ��ƼƼ�� PC���� �и�(detach)
		// update ���� ���� �ȵ�
		
		transaction.commit(); 
		
		Book foundBookTwice = manager.find(Book.class, id);
		assertNotEquals(foundBook, foundBookTwice);
	}

	@Test
	void testRemove��_�����Ұ��_PC��_DB����_�����Ͱ�_���ŵȴ�() {
		int id = 1;
		transaction.begin();
		Book foundBook = manager.find(Book.class, id);
		manager.remove(foundBook);
		
		transaction.commit();
		
		assertThrows(NullPointerException.class, () -> { // In Java, Thin Arrow(() -> {})
			
			// ������ remove�� �Ǿ��� ������ select�� ������ �������� �ʰ�, null�� �Ҵ��
			Book foundBookTwice = manager.find(Book.class, id);
			// null.updateBookName()�� �����߱� ������ nullPointer �߻�(�׽�Ʈ ����)
			foundBookTwice.updateBookName("Effective Unit Testing");
			
			// PC�� ���������� SELECT�� �������� �ʱ� ������ ������ �ִ� ��ƼƼ�� �� �� true�� ���� ��
			
			// 'foundBook == foundBookTwice ������ ����� false�� ���̴�'��� ������
			assertFalse(foundBook == foundBookTwice);
		});
	}

	@Test
	void test���Ӽ����ؽ�Ʈ��_�ʱ�ȭ�Ұ��_���_��ƼƼ��_���ŵ�() {
		int id = 2;
		
		Book foundBook = manager.find(Book.class, id);
		
		manager.clear(); // PC�� û��. ��� ��ƼƼ ����.
		
		Book foundBookTwice = manager.find(Book.class, id);
		
		assertFalse(foundBook == foundBookTwice);
	}

	@Test
	void test��ƼƼ�Ŵ�����_���ŵ�() {
		EntityManager beforeClose = manager;
		System.out.println(manager); // SessionImpl(1202929159<open>)
		
		manager.close();
		
		EntityManager afterClose = manager;
		
		assertEquals(beforeClose, afterClose);
		
		System.out.println(manager); // SessionImpl(1202929159<closed>)
	}

}
