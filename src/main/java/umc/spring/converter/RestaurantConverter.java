package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantRequestDTO;

import java.time.Instant;

public class RestaurantConverter {

    public static Restaurant toRestaurant(RestaurantRequestDTO dto, Region region) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRegion(region);
        restaurant.setRestaurantName(dto.getRestaurantName());
        restaurant.setCategory(dto.getCategory());
        restaurant.setRating(dto.getRating());
        restaurant.setCreatedAt(Instant.now());
        restaurant.setUpdatedAt(Instant.now());
        return restaurant;
    }
}
