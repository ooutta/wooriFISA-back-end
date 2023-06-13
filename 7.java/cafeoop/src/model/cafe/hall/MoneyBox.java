package model.cafe.hall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 캐셔가 손님에게 전달받은 금액을 보관하는 클래스
 *
 * Field Summary
 * 1. int balance
 * 2.
 */
@Getter @Setter
@AllArgsConstructor
public class MoneyBox {
    private int balance;
}
