package dev.syntax.step03generic.step01;

public class WithoutGeneric {

	public static void main(String[] args) {
		Box fruiBox = new Box();
		Apple apple1 = new Apple();
		Banana banana1 = new Banana();
		
		fruiBox.setAnyFruit(apple1);
		fruiBox.setAnyFruit(banana1); // 물론 사과의 참조값이 바나나로 대체하게 됨
		
		// 한계점1 : 직접 다운캐스팅 필요
		Banana newBanana = (Banana) fruiBox.getAnyFruit();
		
		// 한계점2 : 런타임 에러 발생 가능성 있음(현재 Banana가 들어있기 때문에)
		Apple apple = (Apple)fruiBox.getAnyFruit();
		
		// 한계점3 : 과일 말고 다른 모든 객체들도 포함될 수 있음
	}
}
