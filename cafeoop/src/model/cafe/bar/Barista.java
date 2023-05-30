package model.cafe.bar;

import model.cafe.CafeManagementSystem;
import model.cafe.hall.Order;
import model.cafe.hall.OrderInfo;
import model.common.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 바리스타는 캐셔로부터 음료 주문 내역을 전달받고, 음료를 제조할 수 있음
 * Field Summary
 *
 * Method Summary
 * 1. 캐셔에게 주문 내역을 전달받음 - 캐셔가 전달하는 기능과 중복?
 * - 바리스타는 캐셔가 전달하는 주문을 거절할 순 없기 때문에 캐셔가 전달하는 기능으로 대체
 * 2. 음료를 제조함 - DrinkProduct dropTheDrink()
 * 3. 만들어진 음료를 캐셔에게 전달 - sendDrink()
 * - 음료 제조에 걸리는 시간은 바리스타가 결정하기 때문에 별도의 메서드로 작성
 */
public class Barista extends Employee {


    public DrinkProduct dropTheDrink(Order order) {
        // Drink 제조
        OrderInfo requirement = order.getOrderInfo();

        // 주문받은 음료이름 확인
        String drinkName = requirement.getDrinkName();
        System.out.println(drinkName);

        // 카페 시스템에서 음료 레시피 조회
        Recipe foundRecipe = CafeManagementSystem.findRecipeByDrinkName(this, drinkName);

        // 음료 내리기
        DrinkMaker maker = new DrinkMaker();
        Drink droppedDrink = maker.dropDrink(foundRecipe);
        System.out.println(droppedDrink);

        // DrinkProduct 완성 후 반환
        Cup cupStyle = requirement.isTakeOut() ? Cup.PLASTIC : Cup.MUG;
        DrinkProduct drinkProduct = new DrinkProduct(cupStyle, droppedDrink, "잘 저어 마시쇼");

        return drinkProduct;
    }
}
