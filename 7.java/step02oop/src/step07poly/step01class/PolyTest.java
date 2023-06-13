package step07poly.step01class;

public class PolyTest {

	public static void main(String[] args) {
		// 참조변수 animal의 타입은 Animal
		Animal animal = new Whale();
		animal.name = "Animal 타입으로";
		animal.sing();
		
		// 참조변수 whale의 타입이 Whale
		Whale whale = new Whale();
		whale.name = "Whale 타입으로";
		whale.sing();
		
		// 상위 클래스의 참조변수 animal로는 하위 클래스의 멤버 사용 불가
//		animal.swim(); 
		
		// whale 타입이기 때문에 참조 가능
		whale.swim();
		
		// 참조 변수의 타입이 중요
		
//		Whale w = (Whale)new Animal(); // 컴파일 에러는 해결 가능
	}

}
