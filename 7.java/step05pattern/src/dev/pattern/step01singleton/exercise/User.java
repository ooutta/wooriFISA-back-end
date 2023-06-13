package dev.pattern.step01singleton.exercise;

public class User {
	private Ticket myTicket;
	
	public void useTicketMachine() {
		TicketMachine ticketMachine = TicketMachine.operateTicketMachine();
		myTicket = ticketMachine.getTicket();
		ticketMachine.checkValidTicket(myTicket);
	}
	
	public Ticket getMyTicket() {
		return myTicket;
	}
	
	@Override
	public String toString() {
		return "User : " + Integer.toHexString(hashCode());
	}
	
	
}
