package dev.spring.step02factory;

public class MyRoom {

	public static void main(String[] args) {
		
		// MyRoom���� TapeReader�� ���� �������� ���ߴ� ���
		// -> MyRoom.java���� new�� �������� �ʰ�, TapeReader�� �����Ͽ� ����ϴ� ���??
		
		// ���丮 �޼��� : ��ü�� �����ϴ� ��(Factory.java)�� ����ϴ� ��(MyRoom.java)�� �и�
		TapeReader reader = TapeReaderFactory.createTapeReader();
		reader.test();

		TapeReader reader2 = TapeReaderFactory.createTapeReader();
		reader2.test();
	}

	// MyRoom -> TapeReader
	// TapeReader -> Tape
}
