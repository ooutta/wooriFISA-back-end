package dev.pattern.step01singleton.exercise;

public abstract class Ticket {
	long serialNumber;
	
	// 티켓의 고유 번호 확인
	abstract long getTicketNum();
}
