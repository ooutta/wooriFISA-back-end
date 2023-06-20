package dev.syntax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;
	
	@Column(name = "student_name", nullable = false)
	private String studentName;

	@ManyToOne // N���� �л��� 1���� ������ ���� �� �ִ�.
	@JoinColumn(name = "major_id") // �̰� �� ��� Major Ŭ������ ���εȴ�.
	// -> �ܷ�Ű ���� �� ���, name �Ӽ��� ������ �ܷ�Ű �̸� ����
	private Major major;
	
	public void setMajor(Major major) {
		this.major = major;
	}
	
	public Major getMajor() {
		return major;
	}
	
	public Student() {}
	
	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	public Student(int id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + "]";
	}
}
