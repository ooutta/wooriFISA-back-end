package model.cafe.bar;

import java.util.List;

/**
 * Drink를 만들어주는 기계(Factory)
 * 
 */
public class DrinkMaker {

    Drink dropDrink(Recipe recipe) {
        return Drink.builder().name(recipe.getName()).recipe(recipe).build();
    }
}
