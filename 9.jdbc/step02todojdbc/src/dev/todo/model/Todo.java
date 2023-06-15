package dev.todo.model;

import java.time.LocalDate;

public class Todo {
	private int id;
    private String title; // �� �� ����
    private String description; // �� �� ����
    private LocalDate dueDate; // �� �� �����Ⱓ
    private boolean isCompleted; // ���� ����
    
	public Todo(int id, String title, String description, LocalDate dueDate, boolean isCompleted) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = isCompleted;
	}

	// Builder Ÿ���� �μ��� �޴� ������
	public Todo(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.description = builder.description;
		this.dueDate = builder.dueDate;
		this.isCompleted = builder.isCompleted;
		System.out.println(this);
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", isCompleted=" + isCompleted + "]";
	}
	
	// ����(Builder) ����(��ü ����� ���õ� ����)
	public static class Builder { // inner Ŭ����
		private int id;
	    private String title; // �� �� ����
	    private String description; // �� �� ����
	    private LocalDate dueDate; // �� �� �����Ⱓ
	    private boolean isCompleted; // ���� ����
	    
	    // id�� �ʵ�� �޴� ������
	    // id�� �ʼ� �ʵ��� ���
	    public Builder(int id) {
	    	this.id = id;
	    }
	    
	    public Builder title(String title) {
	    	this.title = title;
	    	return this; // ��ȯ Ÿ���� �ڱ� �ڽ�
	    }
	    
	    public Builder description(String description) {
	    	this.description = description;
	    	return this; // ��ȯ Ÿ���� �ڱ� �ڽ�
	    }
	    
	    public Builder dueDate(LocalDate dueDate) {
	    	this.dueDate = dueDate;
	    	return this; 
	    }
	    
	    public Builder isCompleted(boolean isCompleted) {
	    	this.isCompleted = isCompleted;
	    	return this; // ��ȯ Ÿ���� �ڱ� �ڽ�
	    }
	    
	    public Todo build() {
	    	return new Todo(this);
	    }
	    
	}
	
	
	
}