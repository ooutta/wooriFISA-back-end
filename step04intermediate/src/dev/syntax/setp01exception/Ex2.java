package dev.syntax.setp01exception;

public class Ex2 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i=0;i<10;i++) {
			try {
				result = number / (int)(Math.random() * 10);
			} catch (Exception e) {
				// 0으로 나누는 상황이 발생하면 내부적으로 new ArithMeticException();가 생성됨
				// Exception e = new ArithMeticException();가 수행됨
				System.out.println(e);
				e.printStackTrace();
				
				// 예외가 발생할 경우, 실행될 코드를 작성하는 부분
				System.out.println("0으로 나눌 수 없습니다.");
			}
			System.out.println(result);
		}
	}

}
