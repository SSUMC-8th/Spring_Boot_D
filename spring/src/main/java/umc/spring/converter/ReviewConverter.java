package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Review;
import umc.spring.web.dto.review.AddReviewResponse;

@Component
public class ReviewConverter {
    public AddReviewResponse toResponse(Review r) {
        return new AddReviewResponse(r.getId());
    }
}
