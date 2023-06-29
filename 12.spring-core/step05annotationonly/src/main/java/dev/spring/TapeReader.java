package dev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TapeReader {

	private Tape tape;
	
	public TapeReader() {
		super();
	}
	
	@Autowired // 기본 생성자 있으면 이거 설정하고, 생성자가 하나라면 이거 설정 안해도 됨
	public TapeReader(Tape tape) {
		super();
		this.tape = tape;
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

