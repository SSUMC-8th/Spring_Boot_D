package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantReviewResponseDTO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantConverter {

    // RestaurantRequestDTO → Restaurant 엔티티
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

    // Review → ReviewPreviewDTO
    public static RestaurantReviewResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review) {
        return RestaurantReviewResponseDTO.ReviewPreviewDTO.builder()
                .nickname(review.getMember().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(LocalDateTime.ofInstant(review.getCreatedAt(), ZoneId.systemDefault()))
                .build();
    }

    // Page<Review> 관련 정보 → ReviewPreviewListDTO
    public static RestaurantReviewResponseDTO.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewPage) {
        List<RestaurantReviewResponseDTO.ReviewPreviewDTO> previewDTOList = reviewPage.getContent().stream()
                .map(RestaurantConverter::toReviewPreviewDTO)
                .collect(Collectors.toList());

        return RestaurantReviewResponseDTO.ReviewPreviewListDTO.builder()
                .reviewList(previewDTOList)
                .listSize(previewDTOList.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }
}
