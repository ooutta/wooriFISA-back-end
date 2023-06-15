package dev.todo.model;

import java.time.LocalDate;

public class Todo {
	private int id;
    private String title; // 할 일 제목
    private String description; // 할 일 내용
    private LocalDate dueDate; // 할 일 마감기간
    private boolean isCompleted; // 진행 여부
    
	public Todo(int id, String title, String description, LocalDate dueDate, boolean isCompleted) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = isCompleted;
	}

	// Builder 타입을 인수로 받는 생성자
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
	
	// 빌더(Builder) 패턴(객체 생상과 관련된 패턴)
	public static class Builder { // inner 클래스
		private int id;
	    private String title; // 할 일 제목
	    private String description; // 할 일 내용
	    private LocalDate dueDate; // 할 일 마감기간
	    private boolean isCompleted; // 진행 여부
	    
	    // id를 필드로 받는 생성자
	    // id가 필수 필드일 경우
	    public Builder(int id) {
	    	this.id = id;
	    }
	    
	    public Builder title(String title) {
	    	this.title = title;
	    	return this; // 반환 타입이 자기 자신
	    }
	    
	    public Builder description(String description) {
	    	this.description = description;
	    	return this; // 반환 타입이 자기 자신
	    }
	    
	    public Builder dueDate(LocalDate dueDate) {
	    	this.dueDate = dueDate;
	    	return this; 
	    }
	    
	    public Builder isCompleted(boolean isCompleted) {
	    	this.isCompleted = isCompleted;
	    	return this; // 반환 타입이 자기 자신
	    }
	    
	    public Todo build() {
	    	return new Todo(this);
	    }
	    
	}
	
	
	
}