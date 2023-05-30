package model.cafe.hall;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 주문서 클래스
 * Field Summary
 * 1. 주문 정보 - OrderInfo
 * 2. 주문 고객 정보 - CustomerInfo
 */

@AllArgsConstructor
@Getter
public class Order {
    private OrderInfo orderInfo;
    private CustomerInfo customerInfo;
}
