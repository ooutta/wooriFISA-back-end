package dev.spring;

public class TapeReader {
private Tape tape;
	
	public TapeReader() {
		super();
	}
	
	public TapeReader(Tape tape) {
		super();
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
