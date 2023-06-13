package dev.pattern.step01singleton.exerciseClassCode;

import java.util.logging.Logger;

public class User {

	private static Logger logger = Logger.getLogger(TicketMachine.class.getName());
	private Ticket myTicket;

	public void useTicketMachine() {
		TicketMachine machine = TicketMachine.operateTicketMachine();
		logger.info(String.format("%s가 %s 티켓 발급기를 사용 중", this, machine));
		myTicket = machine.getTicket();
	}

	public Ticket getMyTicket() {
		return myTicket;
	}

	@Override
	public String toString() {
		return String.format("User %s", Integer.toHexString(hashCode()));
	}

}
