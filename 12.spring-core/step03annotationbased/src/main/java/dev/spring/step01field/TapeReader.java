package dev.spring.step01field;

import org.springframework.beans.factory.annotation.Autowired;

public class TapeReader {

	@Autowired // 1. �ʵ带 ���ؼ� ������ ����
	private Tape tape;

	public TapeReader() {
		System.out.println("TapeReader() called");
	}
	
	public TapeReader(Tape tape) {
		super();
		this.tape = tape;
	}
	
	public static TapeReader createTapeReader(Tape tape) {
		System.out.println("createTapeReader called");
		TapeReader tapeReader = new TapeReader(tape);
		return tapeReader;
	}
	
	public void test() {
		if (tape.isWorked()) {
			System.out.println(tape.getName() + " ���� �����մϴ�");
		} else {
			System.out.println(tape.getName() + " ��� ���߽��ϴ�");
		}
	}

	@Override
	public String toString() {
		return "TapeReader �Դϴ�.";
	}
}

