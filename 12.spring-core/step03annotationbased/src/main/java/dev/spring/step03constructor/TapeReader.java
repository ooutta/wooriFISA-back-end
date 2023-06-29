package dev.spring.step03constructor;

import org.springframework.beans.factory.annotation.Autowired;

public class TapeReader {

	private Tape tape;

	public TapeReader() {
		System.out.println("TapeReader() called");
	}
	
	@Autowired
	public TapeReader(Tape tape) {
		super();
		System.out.println("TapeReader(Tape tape) called");
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
	
	public void setTape(Tape tape) { // setter �޼��� ��� ������ ����
		this.tape = tape;
	}

	@Override
	public String toString() {
		return "TapeReader �Դϴ�.";
	}
}

