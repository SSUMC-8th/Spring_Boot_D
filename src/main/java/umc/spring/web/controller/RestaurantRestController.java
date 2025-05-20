package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.service.StoreService.RestaurantCommandService;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.JoinResultDTO> join(@RequestBody @Valid RestaurantRequestDTO.JoinDTO reqeust) {
        Restaurant restaurant = restaurantCommandService.joinRestaurant(reqeust);
        return ApiResponse.onSuccess(RestaurantConverter.toJoinResultDTO(restaurant));
    }
}
