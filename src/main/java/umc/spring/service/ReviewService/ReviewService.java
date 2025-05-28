package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.apiPayload.code.ReviewRequestDTO;
import umc.spring.apiPayload.code.ReviewResponseDTO;
import umc.spring.domain.Review;

public interface ReviewService {
    ReviewResponseDTO addReview(Long storeId, ReviewRequestDTO request);
    Page<Review> getMyReviews(Long memberId, int page);
}