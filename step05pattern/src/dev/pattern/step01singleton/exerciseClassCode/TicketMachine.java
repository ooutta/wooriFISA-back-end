package dev.pattern.step01singleton.exerciseClassCode;

import java.util.logging.Logger;
import java.util.stream.LongStream;

public class TicketMachine {
	private static Logger logger = Logger.getLogger(TicketMachine.class.getName());

	private static TicketMachine machine = new TicketMachine();

	private final int MAX_TICKET_LIMIT = 5; // 발행할 수 있는 티켓 수
	private int currentTicketCount;
	private final long[] VALID_SERIAL_NUMBERS = new long[5];

	private TicketMachine() {
		currentTicketCount = 0;
	}

	public static TicketMachine operateTicketMachine() {
		return machine;
	}

	// 티켓 발급
	public Ticket getTicket() {
		if (currentTicketCount < MAX_TICKET_LIMIT) {

			final long validSerialNumber = System.nanoTime();

			VALID_SERIAL_NUMBERS[currentTicketCount] = validSerialNumber;
			currentTicketCount++; // 티켓 카운트 1증가

			return new ValidTicket(validSerialNumber);
		}

		return new InvalidTicket(0L);
	}

	public void checkValidTicket(Ticket ticket) {
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

	// 티켓 머신 고유번호
	@Override
	public String toString() {
		return "Serial No." + Integer.toHexString(hashCode());
	}

}
