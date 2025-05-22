package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.PreferredFood;

import java.util.List;
import java.util.stream.Collectors;

public class PreferredFoodConverter {

    public static List<PreferredFood> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        PreferredFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}

