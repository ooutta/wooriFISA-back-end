package dev.spring.step02constructor;

public class TapeReader {

	private Tape tape;

	public TapeReader() {
		System.out.println("TapeReader() called");
	}
	
	public TapeReader(Tape tape) {
		super();
		System.out.println("TapeReader(Tape tape) called");
		this.tape = tape;
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
