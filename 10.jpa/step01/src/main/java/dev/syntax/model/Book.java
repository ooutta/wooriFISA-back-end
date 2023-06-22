package dev.syntax.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * JPA������ Entity��� ������ Ȱ��
 * �ڹ� �ν��Ͻ�(Object) - DB ���̺��� �ϳ��� �� Row�� �ϳ��� Entity��� �����
 */

@Entity // Book Ŭ������ JPA�� �����ϴ� Entity�� �ν��ϰ� ��
public class Book {
	
	/*
	 * JPA �⺻ Ű ���� ����
	 * 1. ���� �Ҵ�: �⺻Ű ���� ���ø����̼� �ڵ忡��(Java �ڵ��) ���� �Ҵ� ex) int id = 1, id++ ��
	 * 2. �ڵ� ����: DB�� ���� �������ִ� ���
	 * 	1) IDENTITY: �⺻ Ű�� ������ DB���� ����(MySQL�� AUTO_INCREMENT)
	 *  2) SEQUENCE: DB�� �������� ����ؼ� �⺻Ű �Ҵ�(����Ŭ���� ����, MySQL�� ����x)
	 *  3) TABLE: Ű ������ ������ ���̺��� ���, ������ó�� ����ϴ� ���, ���̺��� ����ϱ� ������ ��� DB���� ��� ����
	 *  4) AUTO: DB�� �´� PK �� ���� ������ �ڵ����� ����(������ strategy�� �߰����� ������ �⺻���� AUTO)
	 *  
	 *  ���� �Ҵ� ����� ����Ϸ��� @Id�� ����ϸ� �ǰ�,
	 *  �ڵ� ���� ������ ����Ϸ��� @Id + @GeneratedValue�� �߰��ϰ� ���ϴ� Ű ���� ������ �Ķ���ͷ� �����ϸ� ��
	 */
	
	@Id // primary key ����
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	private int id;
	
	@Column(name = "book_name", nullable = false)
	private String name;
	
	@Column
	private String author; // ���� ����
	
	/*
	 * TemporalType.DATE: ��¥, DB�� date Ÿ�԰� ���� (ex. 2022-03-03) 
	 * TemporalType.TIME: �ð�, DB�� time Ÿ�԰� ���� (ex. 09:30:23) 
	 * TemporalType.TIMESTAMP: ��¥�� �ð�, DB�� datetime Ÿ�԰� ����(ex.2022-12-27 09:53:34)
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pub_date")
	private Date pubDate;
	
	public Book() {
		super();
	}
	
	public Book(String name, Date pubDate) {
		super();
		this.name = name;
	}

	public Book(String name, String author, Date pubDate) {
		super();
		this.name = name;
		this.author = author;
		this.pubDate = pubDate;
	}

	public void updateBookName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", pubDate=" + pubDate + "]";
	}
}