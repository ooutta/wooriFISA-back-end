package step06overriding;

public class MouseTest {

	public static void main(String[] args) {
//		Animal anAnimal = new Animal();
//		
//		anAnimal.name = "어떤 동물";
//		anAnimal.showName();
//		
//		Mouse jerry = new Mouse();
//		jerry.name = "제리";
//		jerry.address = "하와이";
//		
//		jerry.showName();
//		jerry.showName("톰");
		
		// 다형성
		Animal mickey = new Mouse();
		mickey.name = "미키마우스";
//		mickey.address  = "롯데타워"; // 불가
		
		// 상위 타입의 참조변수지만, 오버라이딩 되었기 때문에
		// 예외적으로 Mouse의 오버라이딩된 메서드가 호출됨
		mickey.showName(); // Animal class의 method
		
		// 상위 타입의 참조변수로, 하위 타입의 멤버 사용 불가
//		mickey.showAddr(); // 불가
		
	}

}
