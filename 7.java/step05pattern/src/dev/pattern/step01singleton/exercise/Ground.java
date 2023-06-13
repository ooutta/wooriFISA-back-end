package dev.pattern.step01singleton.exercise;

public class Ground {

	private static final int USERS = 5;
	
	public static void main(String[] args) {
//		User user = new User();
//		
//		for(int i=0;i<6;i++) {
//			user.useTicketMachine();
//			user.getMyTicket();
//			System.out.println();
//		}
		
		
		TicketMachine ticketMachine = TicketMachine.operateTicketMachine();
		User[] users = new User[USERS];
		
		// User 5명의 티켓 발급
		for (int i = 0; i < USERS; i++) {
			users[i] = new User();
			users[i].useTicketMachine();
		}
		
		// 유효한 티켓을 발급받은 User가 티켓이 유효한지 확인
		User anUser = users[4];
		ticketMachine.checkValidTicket(anUser.getMyTicket());
		
		// 또 다른 User가 티켓을 발급받고 티켓이 유효한지 확인
		User anotherUser = new User();
		anotherUser.useTicketMachine();
		
		ticketMachine.checkValidTicket(anotherUser.getMyTicket());
		
	}
}
