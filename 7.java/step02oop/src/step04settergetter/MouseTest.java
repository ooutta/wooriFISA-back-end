package step04settergetter;

public class MouseTest {

	public static void main(String[] args) {
//		Mouse mickey = new Mouse("black");
//		System.out.println(mickey);

		Mouse2 mickey = new Mouse2("black");
		mickey.setColor("white");
		System.out.println(mickey.getColor());
	}

}
