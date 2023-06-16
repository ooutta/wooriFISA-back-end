package dev.syntax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cafe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "menu_name", nullable = false)
	private String menuName;
	
	@Column(nullable = false)
	private int price;
	
	public Cafe() {
		super();
	}
	
	public Cafe(String menuName, int price) {
		super();
		this.menuName = menuName;
		this.price = price;
	}



	public Cafe(int id, String menuName, int price) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.price = price;
	}



	@Override
	public String toString() {
		return "Cafe [id=" + id + ", menuName=" + menuName + ", price=" + price + "]";
	}
	
	
}
