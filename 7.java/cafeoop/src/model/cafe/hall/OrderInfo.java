package model.cafe.hall;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import model.common.Employee;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 주문 정보 클래스
 * 주문(Order) 클래스에 필드로 구성됨
 *
 * Field Summary
 * 1. 주문 음료명 - drinkName
 * 2. 주문 날짜 - orderDate(process에서 동작한 시간으로?)
 * 3. 테이크아웃 여부 - boolean takeOut;
 * 4. 주문 요청 사항 - String customerRequirement
 * 5. 주문 담당자 - List<Employee> manager;
 */
@AllArgsConstructor
@Getter
@ToString
public class OrderInfo {
    private String drinkName; // 필수 필드
    private int change; // 필수 필드
    private LocalDateTime orderDate; // 필수 필드
    private List<Employee> managers; // 필수 필드
    private boolean takeOut; // 필수 필드
    private String customerRequirement; // 있을 수도, 없을 수도 있는 값

    private OrderInfo(Builder builder) {
        this.drinkName = builder.drinkName;
        this.change = builder.change;
        this.orderDate = builder.orderDate;
        this.managers = builder.managers;
        this.takeOut = builder.takeOut;
        this.customerRequirement = builder.customerRequirement;
    }

    public static class Builder {

        // 필수 필드
        private String drinkName;
        private int change;
        private LocalDateTime orderDate;
        private List<Employee> managers;
        // 선택 필드
        private boolean takeOut;
        private String customerRequirement;

        public Builder(String drinkName, int change, LocalDateTime orderDate, List<Employee> managers) {
            this.drinkName = drinkName;
            this.change = change;
            this.orderDate = orderDate;
            this.managers = managers;
        }

        public Builder setIsTakeOut(boolean takeOut) {
            this.takeOut = takeOut;
            return this;
        }

        public Builder setCustomerRequirement(String customerRequirement) {
            if (customerRequirement != null && !"".equals(customerRequirement)) {
                this.customerRequirement = customerRequirement;
            } else {
                this.customerRequirement = "별도 요구사항 없음";
            }
            return this;
        }

        public OrderInfo build() {
            return new OrderInfo(this);
        }
    }

}