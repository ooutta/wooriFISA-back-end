package model.cafe.hall;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor // 모든 매개변수를 받는 생성자
@ToString
public class Customer {
	private final String nickName;
    private CustomerInfo customerInfo;
    private int balance; // 잔액
    
    // 손님의 메뉴 조회
    public void checkMenu() {
    	Scanner sc = new Scanner(System.in);
    	
    	// 담당 스태프 생성
    	
    	
    	int isMenuNeeded = sc.nextInt();
    	System.out.println(isMenuNeeded);
    }
}
