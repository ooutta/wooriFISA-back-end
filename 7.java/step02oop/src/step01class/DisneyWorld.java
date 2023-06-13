package step01class;

public class DisneyWorld {
	public static void main(String[] args) {
		// 참조타입(Mouse) 참조변수 = new 참조타입();
		Mouse mickey = new Mouse();
		
//		System.out.println(mickey);
		mickey.name = "미키마우스";
		System.out.println(mickey.name);
//		System.err.println(mickey.age);
//		System.out.println(mickey.country);
		
		mickey.sing();
		
		Mouse jerry = new Mouse(20);
//		System.out.println(jerry.age);
		System.out.println(jerry.toString());
		System.out.println(jerry);
	}
	
}
