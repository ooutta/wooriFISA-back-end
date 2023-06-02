package dev.syntax.step03generic.step02;

import dev.syntax.step03generic.step01.Apple;
import dev.syntax.step03generic.step01.Banana;

public class FirstGeneric {

	public static void main(String[] args) {
		// Apple 타입만 받을 수 있는 appleBox
		OnlyOneTypeBox<Apple> appleBox = new OnlyOneTypeBox<>();
		Apple apple = new Apple();
		appleBox.set(apple);
		
		// 한계점 해결 : 다운캐스팅 하지 않아도 됨
		Apple appleFromBox = appleBox.get();
		
		// 장점1 : 실수로라도 다른 타입으로 세팅할 수 없음
		Banana banana = new Banana();
//		appleBox.set(banana);
		
		// 우측에는 <> 안에 내용 안 써줘도 됨
		OnlyOneTypeBox<Banana> bananaBox = new OnlyOneTypeBox<>();
		
		// 장점2 : 강제 형변환도 불가능(애초에 서로 다른 타입이기 때문에)
		Apple apple = (Apple)bananaBox.get();
		
	}
}
