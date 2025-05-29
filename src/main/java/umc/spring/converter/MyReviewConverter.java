package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.MyReviewResponseDTO;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class MyReviewConverter {

    // Review → MyReviewDTO
    public static MyReviewResponseDTO.MyReviewDTO toMyReviewDTO(Review review) {
        return MyReviewResponseDTO.MyReviewDTO.builder()
                .restaurantName(review.getRestaurant().getRestaurantName())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(LocalDateTime.ofInstant(review.getCreatedAt(), ZoneId.systemDefault()))
                .build();
    }

    public static MyReviewResponseDTO.MyReviewListDTO toMyReviewListDTO(
            List<Review> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {
        List<MyReviewResponseDTO.MyReviewDTO> dtoList = reviewList.stream()
                .map(MyReviewConverter::toMyReviewDTO)
                .collect(Collectors.toList());

        return MyReviewResponseDTO.MyReviewListDTO.builder()
                .reviewList(dtoList)
                .listSize(listSize)
                .totalPage(totalPage)
                .totalElements(totalElements)
                .isFirst(isFirst)
                .isLast(isLast)
                .build();
    }
}
