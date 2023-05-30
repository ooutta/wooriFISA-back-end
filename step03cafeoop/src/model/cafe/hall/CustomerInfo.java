package model.cafe.hall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

/**
 * 고객의 기본적인 정보를 포함하고 있는 클래스
 * Customer, Order의 필드로 포함됨
 *
 * Field Summary
 * 1. 이전 주문 기록 - List<String> orderHistory(Order에서 주문한 메뉴들만 리스팅)
 * 2. 매장 이용 횟수 - int visitCount
 *
 * Method Summary
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자
public class CustomerInfo {
    private HashMap<String, Integer> orderHistory; // 음료 별 횟수
    private int visitCount;
}