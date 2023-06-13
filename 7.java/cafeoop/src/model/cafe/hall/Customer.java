package model.cafe.hall;

import lombok.*;
import model.cafe.CafeManager;
import model.common.Person;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * 고객은 음료(Drink)를 주문할 수 있음
 * 고객은 음료 주문 시 금액을 결제, 지불해야함
 * 고객이 가진 돈 보다 높은 금액의 음료는 주문 불가능
 * 고객이 음료를 마시면 음료는 줄어듦
 *
 * Field Summary
 * 1. 카페에서 사용할 주문용 닉네임 - String nickName
 * 2. 카페에서 사용할 돈 - String balance
 *
 * Method Summary
 * 1. 메뉴 보기 - Menu checkMenu()
 * 2. 메뉴 결정, 캐셔에게 음료 주문 및 결제 - void confirmMenu(String menuItemName)
 */

@Setter @Getter
@AllArgsConstructor
@ToString
public class Customer extends Person {

    private final String nickName;
    private CustomerInfo customerInfo;
    private int balance; // 잔액


    public void checkMenu() {
        Scanner sc = new Scanner(System.in);
        // 담당 캐셔 배정

        Staff staff = CafeManager.getInstance().getStaffs().get(0);

        // 캐셔에게 메뉴판을 요청하면 캐셔는 메뉴판을 줘야하는데, 손님이 메뉴판을 달라고하지 않을 수도 있음
        System.out.print("메뉴판이 필요하시면 1번 선택, 아니면 바로 주문 진행합니다 ->  ");
        int isMenuNeeded = sc.nextInt();
        sc.nextLine();
        if(isMenuNeeded == 1) {
            Menu menu = staff.showMenu();
            System.out.println(menu);
            System.out.print("주문할 음료를 말씀하세요(ex. 페퍼민트, 얼그레이 등) -> ");
            String drink = sc.nextLine();
            System.out.println(drink);

            confirmMenu(staff, drink);

        } else {
        // 스캐너로 주문할 메뉴 입력 받기
            System.out.print("주문할 음료를 말씀하세요(ex. 페퍼민트, 얼그레이 등");
            sc.nextLine();
            String drink = sc.nextLine();
            confirmMenu(staff, drink);
    }

    }

    // 메뉴 결정하기
    void confirmMenu(Staff staff, String drinkName) {
        // 캐셔에게 음료 주문 및 결제, 음료 수령
        Product myProduct = staff.receiveOrder(this.nickName ,drinkName, balance);

        // 거스름돈 받고, 잔액에서 차감
        Recipt myRecipt = myProduct.getRecipt();
        int change = myRecipt.getOrderInfo().getChange();
        System.out.println("거스름돈: " + change);
        balance -= change; // balance = balance - change;

        System.out.println(myProduct);
        // 음료 팁 확인
        String tip = myProduct.getDrinkProduct().getDrinkTip();
        System.out.println(tip);

        // 음료 레시피는?
//        myProduct.getDrinkProduct().getDrink(); // 접근 불가

        // 현재 잔액 확인
        System.out.println("현재 잔액은 " + balance + "입니다.");
    }
}