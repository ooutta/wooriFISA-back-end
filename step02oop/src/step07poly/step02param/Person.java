package step07poly.step02param;

public class Person {
	// 동물과 산책하는 기능
	void walk(Animal a) {
		if(a instanceof Cat) {
			Cat c = (Cat) a;
			// 전달받은 a가 new Animal()이 아닐 경우, Cat 타입으로 안전하게 형 변환 가
			// 결국 Cat c = new Cat();이 된다는 의미
			c.play();
		} else if(a instanceof Dog) {
			Dog d = (Dog) a;
			d.play();
		} 
	}
}
