package umc.spring.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import javax.sound.sampled.ReverbType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class RestaurantConverter {

    public static RestaurantResponseDTO.RestaurantJoinResultDTO toJoinResultDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.RestaurantJoinResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.RestaurantJoinDTO request) {
        return Restaurant.builder()
                .name(request.getName())
                .type(request.getType())
                .score(request.getScore())
                .time(request.getTime())
                .missionList(new ArrayList<>())
                .restaurantPictureList(new ArrayList<>())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .restaurantName(review.getRestaurant().getName())
                .ownerNickname(review.getMember().getNickname())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getText())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList) {

        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO)
                .collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPages(reviewList.getTotalPages())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
