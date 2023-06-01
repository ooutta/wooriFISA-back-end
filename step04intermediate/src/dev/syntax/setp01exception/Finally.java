package dev.syntax.setp01exception;

public class Finally {

	public static void main(String[] args) {
		method1();
		
	}
	
	public static void method1() {
		try {
			System.out.println("method1 호출됨");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 보통 자원 반납할 때 사용
			System.out.println("method1()의 finally block 호출됨");
		}
	}
}
