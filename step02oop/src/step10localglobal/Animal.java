package step10localglobal;

import java.applet.Applet;

public class Animal {
	int age; // 전역변수 중 인스턴스 변수 -> 인스턴스를 생성하지 않으면 접근 불가
	static String kind; // 전역변수 중 static(정적, 클래스) 변수 -> 인스턴스 안 만들어도 접근 가능
	
	void instanceMethod() { // 인스턴스 메서드
		System.out.println(age); // 가능
		/*
		 * 인스턴스 메서드가 호출된다는 것은 인스턴스가 이미 생성되었다는 것이기 때문에
		 * 인스턴스 변수인 age 역시 접근(사용) 가능
		 */
		System.out.println(kind); // 가능
		// static은 항상 인스턴스보다 메모리(method area)에 먼저 생기기 때문에 가능
	
		staticMethod(); // 가능
	}
	
	static void staticMethod() {
//		System.out.println(age); // 불가능
		/*
		 * static에 staticMethod()가 올라갈 시점에는
		 * 인스턴스가 생성되지 않았을 수 있기 때문에 불가능
		 */
		System.out.println(kind); // 가능
		
		// 인스턴스를 먼저 생성했기 때문에 가능
		Animal a = new Animal();
		a.age = 20;
		System.out.println(a.age);
		
	}
}
