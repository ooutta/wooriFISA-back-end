package dev.spring.step01dependency;

public class Tape {
	String name; // ������ �̸�
	boolean isWorked; // �������� ���� �۵� �ϴ���?
	
	public Tape(String name, boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}
	public String getName() {
		return name;
	}
	
	public boolean isWorked() {
		return isWorked;
	}	
}