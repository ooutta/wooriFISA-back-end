package dev.spring.step01setter;

public class TapeReader {

	private Tape tape;

	public TapeReader() {
		System.out.println("TapeReader() called");
	}
	
	public void test() {
		if (tape.isWorked()) {
			System.out.println(tape.getName() + " ���� �����մϴ�");
		} else {
			System.out.println(tape.getName() + " ��� ���߽��ϴ�");
		}
	}

	public void setTape(Tape tape) {
		System.out.println("setTape() �Դϴ�.");
		this.tape = tape;
	}

	@Override
	public String toString() {
		return "TapeReader �Դϴ�.";
	}
}
