package umc.spring.converter;

import umc.spring.domain.Food;
import umc.spring.domain.mapping.FavoriteFood;

import java.util.List;
import java.util.stream.Collectors;

public class FavoriteFoodConverter {

    public static List<FavoriteFood> toFavoriteFoodList(List<Food> foodList){

        return foodList.stream()
                .map(food ->
                        FavoriteFood.builder()
                                .food(food)
                                .build()
                ).collect(Collectors.toList());
    }
}
