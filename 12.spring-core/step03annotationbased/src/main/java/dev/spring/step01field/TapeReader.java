package dev.spring.step01field;

import org.springframework.beans.factory.annotation.Autowired;

public class TapeReader {

	@Autowired // 1. 필드를 통해서 의존성 주입
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
			System.out.println(tape.getName() + " 정상 동작합니다");
		} else {
			System.out.println(tape.getName() + " 사기 당했습니다");
		}
	}

	@Override
	public String toString() {
		return "TapeReader 입니다.";
	}
}

