package umc.spring.service.ReviewService;

import umc.spring.apiPayload.code.ReviewRequestDTO;
import umc.spring.apiPayload.code.ReviewResponseDTO;

public interface ReviewService {
    ReviewResponseDTO addReview(Long storeId, ReviewRequestDTO request);
}