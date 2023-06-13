package dev.syntax.step03generic.step02;

// 하나의 타입만 받을 수 있는 클래스
// <> : diamond operator(다이아몬드 연산자)
// 클래스 옆에 작성
public class OnlyOneTypeBox<T> {
	// T에 들어오는 타입에 따라
	// private Apple t; 또는
	// private Banana t;가 된다.
	private T t; 

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
	
	
}
