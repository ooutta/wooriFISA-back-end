package dev.syntax.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name = "coffee") 
public class Coffee {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;

	public Coffee() {
		super();
	}

	public Coffee(String name) {
		this.name = name;
	}

	public void setId(Long id) {
//		System.out.println("setId(String id) called");
		this.id = id;
	}

	public Long getId() {
//		System.out.println("getId() called");
		return id;
	}

	public String getName() {
//		System.out.println("getName() called");
		return name;
	}

	public void setName(String name) {
//		System.out.println("setName(String name) called");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Coffee [id=" + id + ", name=" + name + "]";
	}

}