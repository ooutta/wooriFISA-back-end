package model.cafe.hall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 카페 메뉴 클래스
 * Field Summary
 * 1. 메뉴 제목 - String title
 * 2. 메뉴 아이템 - List<MenuItem> menuList
 *
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private String title;
    private List<MenuItem> menuList;

    @Override
    public String toString() {
        for (MenuItem menuItem: menuList) {
            System.out.println("음료명: " + menuItem.getName());
//            System.out.println("가격: " + menuItem.getPrice() +"원 / " + "소요 시간 : " + menuItem.getPreparingTime() + "분" + " 인기도 : " + menuItem.getPopular());
            System.out.println(menuItem);
        }

        return "결정되면 staff에게 주문하세요";
    }
}
