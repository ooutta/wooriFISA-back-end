package model.cafe.hall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 영수증 클래스
 * Field Summary
 * 1. 거래 날짜 - transactionDate
 * 2. 주문 정보 - OrderInfo orderInfo
 */
@AllArgsConstructor
@Getter
@ToString
public class Recipt {
    private LocalDateTime transactionDate;
    private OrderInfo orderInfo;

}
