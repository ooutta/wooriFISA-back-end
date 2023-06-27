package dev.spring.step02factory;

public class MyRoom {

	public static void main(String[] args) {
		
		// MyRoom에서 TapeReader에 대한 의존성을 낮추는 방법
		// -> MyRoom.java에서 new를 생성하지 않고, TapeReader를 생성하여 사용하는 방법??
		
		// 팩토리 메서드 : 객체를 생성하는 쪽(Factory.java)과 사용하는 쪽(MyRoom.java)을 분리
		TapeReader reader = TapeReaderFactory.createTapeReader();
		reader.test();

		TapeReader reader2 = TapeReaderFactory.createTapeReader();
		reader2.test();
	}

	// MyRoom -> TapeReader
	// TapeReader -> Tape
}
