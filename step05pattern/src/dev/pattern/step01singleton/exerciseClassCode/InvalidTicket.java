package dev.pattern.step01singleton.exerciseClassCode;

public class InvalidTicket extends Ticket {
	
	public InvalidTicket(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public long getTicketNum() {
		return 0L;
	}
	
}
