package dev.food.step01servletonly;

public class Client {

	public String requestMessage(Owner owner, String foodName) {
		String myFood = owner.receiveOrder(foodName, "-");
		return myFood;
	}
	
	// 프레첼 요리 주문 요청 API
	String requestMessage(TiredOwner owner, String foodName) {

		String myFood = owner.receiveOrder(foodName, "-");
		return myFood;
	}
}
