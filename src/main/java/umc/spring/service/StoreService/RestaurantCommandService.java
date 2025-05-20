package umc.spring.service.StoreService;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantRequestDTO;

public interface RestaurantCommandService {
    Restaurant joinRestaurant(RestaurantRequestDTO.JoinDTO request);
}
