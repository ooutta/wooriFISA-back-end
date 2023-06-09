package dev.spring.step02setter;

import org.springframework.beans.factory.annotation.Autowired;

public class TapeReader {

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
	
	@Autowired
	public void setTape(Tape tape) { // setter 메서드 기반 의존성 주입
		this.tape = tape;
	}

	@Override
	public String toString() {
		return "TapeReader 입니다.";
	}
}

