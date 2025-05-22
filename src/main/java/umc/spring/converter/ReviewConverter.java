package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.Instant;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReview dto, Member member, Restaurant restaurant) {
        Review review = new Review();
        review.setMember(member);
        review.setRestaurant(restaurant);
        review.setRating(dto.getRating());
        review.setContent(dto.getContent());
        review.setCreatedAt(Instant.now());
        review.setUpdatedAt(Instant.now());
        return review;
    }

    public static ReviewResponseDTO.CreateResult toCreateResult(Review review) {
        return ReviewResponseDTO.CreateResult.builder()
                .reviewId(review.getId())
                .restaurantName(review.getRestaurant().getRestaurantName())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
