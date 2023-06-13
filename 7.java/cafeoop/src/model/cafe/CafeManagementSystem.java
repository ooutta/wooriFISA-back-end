package model.cafe;

import model.cafe.bar.Recipe;
import model.cafe.hall.*;
import model.common.Employee;
import model.common.Person;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * Cafe의 데이터베이스
 */
public class CafeManagementSystem {

    public static Customer findCustomerByNickname(Person isWho, String nickName) {
        if(authenticateUser(isWho)) {
            // List<Customer>에서 인덱싱, 조회
            List<Customer> customers = CafeManager.getInstance().getCustomers();
            for (Customer customer : customers) {
                if (customer.getNickName().equals(nickName)) {
                    return customer;
                }
            }
        }
        return null; // 추후 옵셔널 or 빈 객체로 반환
    }

    public static Recipe findRecipeByDrinkName(Person isWho, String drinkName) {
        if (authenticateUser(isWho)) {
            List<Recipe> recipes = CafeManager.getInstance().getRecipes();

            for (Recipe recipe : recipes) {
                if(recipe.getName().equals(drinkName)) return recipe;
            }
        }
        return null;
    }

    public static int calculateChange(Person isWho, String drinkName, int charge) {
        authenticateUser(isWho);

        // Menu에서 drinkName과 일치하는 음료 조회
        Menu menu = CafeManager.getInstance().getMenu();
        List<MenuItem> menuList = menu.getMenuList();
        for(MenuItem menuItem: menuList) {
            if (menuItem.getName().equals(drinkName)) {
                int change = charge - menuItem.getPrice();
                return change;
            }
        }
        // 지불해야할 금액이 부족하면 손님에게 받은 금액 다시 돌려주기
        return charge;
    }

    public static Recipt printRecipt(Person isWho, LocalDateTime now, OrderInfo orderInfo) {
        authenticateUser(isWho);

        return new Recipt(now, orderInfo);
    }

    public static boolean authenticateUser(Person isWho) {
        if(isWho instanceof Employee) {
            return true;
        } else {
            return false;
        }
    }


}
