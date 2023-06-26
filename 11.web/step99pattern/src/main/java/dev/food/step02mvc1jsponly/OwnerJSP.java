package dev.food.step02mvc1jsponly;

/*
 * JSP - Java Server Page의 줄임 표현
 * 간단하게 말하면 Java Code in HTML
 * 즉, HTML 파일 내부에 Java Code 작성 가능
 * 템플릿(Template) 문법, 엔진
 * 
 * 음식을 제조하는 작업이 너무 힘들어서 음식만 넣으면 요리를 편하게 만들 수 있는
 * 요리 템플릿(template) 전용 메서드 구입
 * 
 * 정리하면, Servlet 파일에서 HTML 태그들을 문자열 형태로 작성하던 코드가 사라지게 됨
 * 
 */
public class OwnerJSP { // ex) MouseList.jsp(JSP 확장자)파일과 비슷한 형태라고 가정
	
	String receiveOrder(String foodName, String memo) {
		String orderMenu = foodName;
		String food = null;
		
		if(orderMenu.equals(foodName)) {
			food = cookTemplate(foodName);
		}
		
		return food;
	}
	
	// 요리 템플릿(HTML), 요리만 넣으면 쉽게 완성됨
	String cookTemplate(String foodName) {
		String food = "" + "<awesome-plate>" + foodName + "</awesome-plate>" + "";
		return food;
	}
}
