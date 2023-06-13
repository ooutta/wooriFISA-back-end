package dev.pattern.step01singleton.exerciseClassCode;

public class ValidTicket extends Ticket {

	public ValidTicket(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public long getTicketNum() {
		return this.serialNumber;
	}

}
