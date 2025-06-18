package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Review;
import umc.spring.web.dto.review.AddReviewResponse;
import umc.spring.web.dto.review.ReviewListResponse;

@Component
public class ReviewConverter {
    public AddReviewResponse toResponse(Review r) {
        return new AddReviewResponse(r.getId());
    }

    public ReviewListResponse toReviewListResponse(Review review) {
        return ReviewListResponse.builder()
                .reviewId(review.getId())
                .content(review.getContent())
                .star(review.getStar())
                .createdAt(review.getCreatedAt())
                .build();
    }

}
