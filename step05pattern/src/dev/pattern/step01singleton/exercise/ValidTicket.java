package dev.pattern.step01singleton.exercise;

// 고유한 일련번호를 가지고 있는 티켓 클래스
public class ValidTicket extends Ticket {
	
	public ValidTicket(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public long getTicketNum() {
		return this.serialNumber;
	}
}
