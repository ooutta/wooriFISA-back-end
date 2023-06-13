package model.cafe.hall;

import model.cafe.CafeManagementSystem;
import model.cafe.CafeManager;
import model.cafe.bar.Barista;
import model.cafe.bar.DrinkProduct;
import model.common.Employee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 캐셔는 손님으로부터 주문을 받을 수 있음
 * Field Summary
 * 1. 손님에게 전달받은 금액
 *
 *
 * Method Summary
 * 1. 손님으로부터 주문을 받음 - Recipe receiveOrder()
 * - 손님으로부터 금액, 메뉴이름을 전달받음
 * 2. 손님에게 상품(음료)을 제공함 - serveProduct()
 * - OrderedProduct 준비, 세팅
 * 3. 손님으로부터 주문받은 주문정보를 바리스타에게 전달함 - sendBill()
 * 4. 손님에게 받은 금액을 돈통에 넣음 - saveAmount()
 * 4. 바리스타에게 받는 기능은?
 */
public class Staff extends Employee {
    Menu showMenu() {
        return CafeManager.getInstance().getMenu();
    }

    Product receiveOrder(String nickName, String drinkName, int charge) {
        // 현재 주문 시간
        // TODO: 날짜 포맷팅해서 출력하기 ex) 21.9.2 오후 2:56
//      포맷팅 참고링크:  https://suyou.tistory.com/287
        LocalDateTime currentTime = LocalDateTime.now();
//        System.out.println(String.format("현재 주문 시간은 %"));
        LocalDateTime time = LocalDateTime.now();
        time.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
        System.out.println("현재 주문시간: " + time);

        // 주문 정보 작성

        // 주문, 제조 담당자 지정
        // TODO: 바리스타 랜덤 배정으로 변경
        Barista son = CafeManager.getInstance().getBaristas().get(0);

        // 담당 매니저 배정
        List<Employee> managers = new ArrayList();
        managers.add(this);
        managers.add(son);

        // 고객 정보 확인
        // nickName으로 고객 정보 조회
        Customer foundCustomer = CafeManagementSystem.findCustomerByNickname(this, nickName);
        CustomerInfo customerInfo = foundCustomer.getCustomerInfo();

        // 2. 거스름돈 연산
        int change = CafeManagementSystem.calculateChange(this, drinkName, charge);

        // 주문 정보 작성
        Scanner sc = new Scanner(System.in);
        System.out.print("테이크 아웃?(Y/N)");
        String takeOut = sc.nextLine();
        boolean isTakeOut = takeOut.equals("Y") ? true : false;

        System.out.print("별도의 요청사항 있으십니까?");
        String customerRequirement = sc.nextLine();

        OrderInfo orderInfo = new OrderInfo.Builder(drinkName, change, currentTime, managers).setIsTakeOut(isTakeOut).setCustomerRequirement(customerRequirement).build();

        // 주문서 작성
        Order order = new Order(orderInfo, customerInfo);

        // 영수증 출력
        // 거스름돈 처리는 영수증의 금액으로 계산
        Recipt recipt = CafeManagementSystem.printRecipt(this, currentTime, orderInfo);

        DrinkProduct drinkProduct = son.dropTheDrink(order);
        // 바리스타에게 전달
        Product product = new Product(drinkProduct, recipt, true);

        return product;
    }
}
