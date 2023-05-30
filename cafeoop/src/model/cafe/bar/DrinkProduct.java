package model.cafe.bar;

import lombok.AllArgsConstructor;
import lombok.ToString;
import model.cafe.bar.Cup;
import model.cafe.bar.Drink;

/**
 * 바리스타가 제조를 마친 음료,
 * 캐셔에게 전달되는 음료 상품으로, 최종 상품인 Product 클래스의 구성요소
 *
 * Field Summary
 * 1. 제조된 음료 - Drink drink
 * 2. 음료 마시는 팁 - String drinkTip
 */

// Drink 객체는 레시피가 포함되어 있기 때문에 사용자 측에서 접근 못하게 불변성 적용

@AllArgsConstructor
@ToString
public class DrinkProduct {
    private Cup style;
    private Drink drink;
    private String drinkTip;

    // getDrink()는 작성하지 않음.
    // 따라서, Drink는 Customer 입장에서 조회 불가(레시피가 노출될 수 있기 때문에)

    public Cup getStyle() {
        return style;
    }

    public String getDrinkTip() {
        return drinkTip;
    }
}
