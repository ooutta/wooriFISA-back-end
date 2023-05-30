package model.cafe.hall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import model.cafe.bar.DrinkProduct;

/**
 * 손님에게 제공되는 최종 상품 클래스
 * 캐셔, 고객이 이용할 수 있는 클래스
 *
 * Field Summary
 * 1. 제조된 음료 - DrinkProduct
 * 2. 영수증 - Recipt
 * 3. 쟁반 제공 여부 - isServedWithTray
 *
 * Method Summary
 *
 */
@AllArgsConstructor
@Getter
@ToString
public class Product {
    private DrinkProduct drinkProduct;
    private Recipt recipt;
    boolean isServedWithTray;
}
