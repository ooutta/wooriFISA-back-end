package step01class;

public class DisneyWorld2 {
	public static void main(String[] args) {
		// jerry 생성, 나이 73, 이름은 제리, 주소는 뉴욕시
		Mouse jerry = new Mouse();
		jerry.name = "제리";
		jerry.age = 73;
		jerry.country = "뉴욕시";
		System.out.println(jerry);
		
		// mickey 생성
		Mouse mickey = new Mouse("미키마우스", "미국", 85, "무교", "플로리다주");
		System.out.println(mickey);
	}
	
}
