package dev.food.step01servletonly;

public class TiredOwner {
	String receiveOrder(String foodName, String memo) { // request 객체
		// 음식 정보 확인, 추출
		String orderedMenu = foodName; // request.getParameter("name");

		// 음식 제조 // out.print()
		String food = null;
		// 음식 제조 // out.print()
		if (orderedMenu.equals("프레첼")) {
			food = "" + 
					"<shallowDish>\n"
					+ "&&&\n" 
					+ "&&&\n" 
					+ "&&&\n" 
					+"</shallowDish>";			
		}

		// 홀 서빙 
		return food; // writer.write(responseHTML)
	}
}
