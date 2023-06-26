package dev.food.step02mvc1jsponly;


public class Client {
	public String requestMessage(OwnerJSP owner, String foodName) {
		String myFood = owner.receiveOrder(foodName, "-");
		return myFood;
	}
	
	

}
