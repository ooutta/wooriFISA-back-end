package dev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Tape {
	private String name; 
	private boolean isWorked;

	@Autowired
	public Tape(@Value("아일랜드") String name, @Value("true") boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(String name) called()");
		this.name = name;
	}

	public void setWorked(boolean isWorked) {
		System.out.println("setWorked(boolean isWorked) called()");
		this.isWorked = isWorked;
	}

	public boolean isWorked() {
		return isWorked;
	}
}
