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
		 * Persistence unit: EntityManager�� ���ؼ� �����Ǵ� ��� Entity
		 * 
		 * Entity: JPA�� �����ϴ� Java ��ü(Ŭ����)���� DB �󿡼��� ���̺�� ����
		 * 
		 * EntityManagerFactory: EntityManager�� ������ �� �ִ� Factory(����)
		 * 
		 * EntityManager: Entity�� �������ִ� ������
		 * 
		 * EntityTransaction: �����Ϳ� ���� ����(UPDATE, DELETE, INSERT) �۾��� �ʿ��� �� ���Ǵ� ��ü
		 * SELECT�� �ʿ� x
		 * COMMIT�� ������ ���� ������ �� ���� ����� �� �ֵ���(���� ����) ��� ����
		 * 
		 * Persistence Context: ���Ӽ� ���ؽ�Ʈ
		 */
		
		/*
		 * EntityManager�� �����ϱ� ���� ��ü
		 * Persistence unit�� persistence.xml ���Ͽ� ���� ���� ������ �����
		 */
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
		
		// Factory�� ���ؼ� EntityManager ����
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		/*
		 * ������ Book ���̺��� ����� ���ؼ��� ���� CREATE TABLE book ���� �ۼ�����
		 * JPA�� Ȱ���� ���, Book�̶�� �̸��� Ŭ������ ������ ����, 
		 * ���̺��� �÷����� ���ε� �� �ִ� �� ���� ������ �ۼ��ϸ� �ڵ����� �� ������ �°� ���̺��� ������
		 */
		
		try {
//			transaction.begin();
			// �Ʒ� �� ���� �ϳ��� transaction�̴�.
			// Book ��ü ����
//			Book book = new Book("���ǽ�", Date.valueOf("1995-05-21"));
//			manager.persist(book);
//			transaction.commit();
			
			// �����ϸ� ���� �߻� Book Ŭ������ �⺻ ������ �����
			// Book data ��ȸ: SELECT ~, ������ ��ȸ �۾� transaction �۾��� �ʿ� ����
			Book result = manager.find(Book.class, 1);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close(); // ���������� Connection ��ü�� �ݳ���
			factory.close();
		}
		
	}

}
