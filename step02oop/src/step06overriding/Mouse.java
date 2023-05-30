package step06overriding;

public class Mouse extends Animal {
	String address;
	
	public void showAddr() {
		System.out.printf("%s는 %s에 살아, \n", name, address);;
	}

	// 오버라이딩 - 재정의
	/*
	 * 상위 클래스의 메서드와 같은 메서드 이름
	 * 같은 인수 리스트
	 */
	@Override
	public void showName() {
		System.out.println("내 이름은 비밀");
	}
	
	// 오버로딩 - 중복 정의
	/*
	 * 같은 메서드명, 다른 인수 리스트
	 */
	public void showName(String yourName) {
		System.out.printf("%s 안녕, 나는 %s이야, \n", yourName, name);
	}
	
}
