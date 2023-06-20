package dev.syntax;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step02DoPersist {

	public static void main(String[] args) {
		
		// JPA �������̽�����(java.persistence) �����ϴ� EntityManagerFactory��
		// Persistence Ŭ������ ���̹�����Ʈ ����ü�� �ν��Ͻ�ȭ
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			
			// Book ��ƼƼ ����, manager.persist(book) ���������� transist ����(�񿵼�)
			// ����ȭ �Ǿ����� ����
			// ����ȭ(persist) : ���Ӽ� ���ؽ�Ʈ���� �����ǰ� ���� ���� ����
			Book book = new Book("JPA", "����", new Date());
			
			manager.persist(book); // ����ȭ ����. insert �� ���� ������ָ� �ȴ�.
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
    
	}

}
