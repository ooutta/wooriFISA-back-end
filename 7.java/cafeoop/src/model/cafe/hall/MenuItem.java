package model.cafe.hall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import model.cafe.bar.Drink;

/**
 * Menu에 포함되는 항목 클래스
 *
 * Field Summary
 * 1. 음료 이름 - name
 * 2. 가격 - int price
 * 3. 준비 시간 - int preparingTime
 * 4. 인기도 - popular
 *
 * Method Summary
 */

@Getter
@AllArgsConstructor
public class MenuItem {
    private String name;
    private int price;
    private int preparingTime;
    private int popular;

    @Override
    public String toString() {
        return "음료 정보 : { " +
                "가격=" + price + "원" +
                ", 소요 시간=" + preparingTime + "분" +
                ", 인기도=" + popular +
                " }";
    }
}
