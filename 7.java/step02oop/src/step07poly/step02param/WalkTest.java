package step07poly.step02param;

public class WalkTest {

	public static void main(String[] args) {
		// 산책할 동물 생성
		Cat c = new Cat("Tom");
		Dog d = new Dog("Spike");
		
		// 산책할 사람 생성
		Person p = new Person();
		
		// 누구랑 산책할지를 walk()의 인자로 전달
		p.walk(c);
		p.walk(d);
		
		Animal e = new Animal("어떤 동물임");
		p.walk(e);
	}

}
