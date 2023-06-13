package step05extends;

public class MouseTest {
	public static void main(String[] args) {
		Mouse jerry = new Mouse();
		jerry.setAge(20);
		jerry.setColor("gray");
		System.out.println(jerry);
		
//		Mouse mickey = new Mouse(5);
//		System.out.println(mickey.toString());
//
//		Mouse jamie = new Mouse(5, "red");
//		System.out.println(jamie.toString());
//		
		Mouse joo = new Mouse(5, "red", "뉴욕");
		System.out.println(joo);
		
//		jerry.sing();
	}
}

