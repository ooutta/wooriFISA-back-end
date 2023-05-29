package step02overloading;

public class Mouse {
	int age;
	String name;
	
	// 기본 생성자 메서드
	public Mouse() { }
	
	// 나이만 지정하여 생성하는 생성자 메서드
	public Mouse(int age) {
		this.age = age;
	}

	// 이름만 지정하여 생성하는 생성자 메서드
	public Mouse(String name) {
		this.name = name;
	}

	// 나이와 이름을 지정하여 생성하는 생성자 메서드
	public Mouse(int age, String nameString) {
		this.age = age;
		this.name = name;
	}
	
}
