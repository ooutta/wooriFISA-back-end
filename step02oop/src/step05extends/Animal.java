package step05extends;

public class Animal {
	/*
	 * 상속은 특성을 물려받는 것
	 * 
	 * 특성
	 * 1. 필드
	 * 2. 메서드
	 */
	private int age;
	private String color;
	
	public Animal() {
		System.out.println("Animal() called");
	}
	
	public Animal(int age) {
		this.age = age;
		System.out.println("Animal(age) called");
	}

	public Animal(int age, String color) {
		this.age = age;
		this.color = color;
		System.out.println("Animal(age, color) called");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Animal [age=" + age + ", color=" + color + "]";
	}
	
	public void sing() {
		System.out.println("동물은 어떻게 울지?");
	}
	
	
}
