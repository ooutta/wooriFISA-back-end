package dev.spring.step02setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Tape {
	private String name; // 테이프 이름
	private boolean isWorked; // 정상 동작 여부

	public Tape() {
		super();
		System.out.println("Tape() called");
	}

	public Tape(String name, boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}

	public String getName() {
		return name;
	}

	@Autowired // setter에 Autowired를 설정해야, 이 setter 메서드를 호출해서 초기화 해준다.
	public void setName(@Value("아일랜드") String name) { // 2. 세터로 초기화
		System.out.println("setName(String name) called()");
		this.name = name;
	}

	public boolean isWorked() {
		return isWorked;
	}

	@Autowired
	public void setWorked(@Value("true") boolean isWorked) {
		System.out.println("setWorked(boolean isWorked) called()");
		this.isWorked = isWorked;
	}
}