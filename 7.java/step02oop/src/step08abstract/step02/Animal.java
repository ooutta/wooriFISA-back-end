package step08abstract.step02;

public abstract class Animal { // 추상 클래스. 인스턴수화 못한다.
	abstract void sing(); // 추상 메서드. 선언부만 있고, 구현부는 작성하지 않음
	
	void abc() {
		System.out.println("일반 메서드도 구현은 가능. 인터페이스는 일반 메서드 구현 불가");
	}
}
