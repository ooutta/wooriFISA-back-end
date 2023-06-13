package dev.pattern.step01singleton.exercise;

import java.util.logging.Logger;
import java.util.stream.LongStream;
import java.util.logging.Level;

public class TicketMachine {
	int MAX_TICKET_LIMIT = 5;
	int currentTicketCount;
	long[] VALID_SERIAL_NUMBERS;

	private static TicketMachine ticketMachine = new TicketMachine();
	
	private static final Logger logger = Logger.getLogger(TicketMachine.class.getName());
	
	
	private TicketMachine() {
		currentTicketCount = 0;
		VALID_SERIAL_NUMBERS = new long[MAX_TICKET_LIMIT];
	}
	
	// 티켓 발급
	public Ticket getTicket() {
		logger.log(Level.INFO, ticketMachine.toString());
		
		Ticket ticket;
		if(currentTicketCount < MAX_TICKET_LIMIT) {
			final long validSerialNumber = System.nanoTime();
			
			VALID_SERIAL_NUMBERS[currentTicketCount] = validSerialNumber;

			currentTicketCount++;
			
			return new ValidTicket(validSerialNumber);
		}
		return new InvalidTicket(0L);
	}
	
	// 티켓 머신 인스턴스 취득
	public static TicketMachine operateTicketMachine() {
		return ticketMachine;
	}
	
	// 전달받은 티켓이 유효한지 검증
	public void checkValidTicket(Ticket ticket) {
//		if(ticket instanceof ValidTicket) {
//			logger.info("유효한 티켓입니다.");
//		} else {
//			logger.warning("유효하지 않은 티켓입니다.");
//		}

		
		
		long ticketSerialNumber = ticket.getTicketNum();
		
		boolean isValid = LongStream.of(VALID_SERIAL_NUMBERS).anyMatch(x -> x == ticketSerialNumber);
		if (isValid) {
			logger.info("유효한 티켓입니다.");
			return;
		}

		String message = String.format("발급 한도 초과: %d/%d", currentTicketCount, MAX_TICKET_LIMIT);
		logger.warning("유효하지 않은 티켓입니다.");
		logger.warning(new IllegalStateException(message).getMessage());
	}
	
	@Override
	public String toString() {
		return "티켓 발급기 " + Integer.toHexString(hashCode()) + "를 사용중입니다.";
	}
	
}
