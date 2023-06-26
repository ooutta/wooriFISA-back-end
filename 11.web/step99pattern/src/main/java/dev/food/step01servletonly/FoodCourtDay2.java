package dev.food.step01servletonly;

public class FoodCourtDay2 {
	public static void main(String[] args) {
		Client client = new Client();
		TiredOwner owner = new TiredOwner();
		
		
		String myFood = client.requestMessage(owner, "프레첼");
		
	}
}
