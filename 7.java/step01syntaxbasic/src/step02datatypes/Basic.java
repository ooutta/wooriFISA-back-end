package step02datatypes;

// 자주색으로 작성된 단어들은 키워드(keyword)
public class Basic {

	public static void main(String[] args) {
		// 1. 값의 타입
		
		// 1-1. 대표적인 기본(Primitive) 타입들
		int apples = 7;
		float eyesight = 1.5f; // 실수형 타입은 값 뒤에 f를 명시
		char initialLetter = 'Y'; // 하나의 문자에서만 '' 사용 가능
		// 단 한 글자의 '문자' 타입, 홑따옴표만 가능
		String nameString = "kim"; // 두 글자 이상의 문자'열' 타입, 쌍따옴표만 가능
		boolean isChecked = true; // 논리형 타입(true/false)
		
		System.out.println(apples);
		System.out.println(eyesight);
		System.out.println(initialLetter);
		System.out.println(nameString);
		System.out.println(isChecked);
	}
}
