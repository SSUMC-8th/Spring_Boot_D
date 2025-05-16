package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.exception.GeneralException;
import umc.spring.apipayload.status.ErrorResponse;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.domain.Store;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.review.AddReviewRequest;

@Service
@RequiredArgsConstructor
public class ReviewService {
        private final StoreRepository storeRepo;
        private final ReviewRepository reviewRepo;

        @Transactional
        public Review addReview(Long storeId, AddReviewRequest req) {
            Store store = storeRepo.findById(storeId)
                    .orElseThrow(() -> new GeneralException(ErrorResponse.STORE_NOT_FOUND));

            Review r = Review.builder()
                    .content(req.getContent())
                    .star(req.getStar())
                    .build();

            // 연관된 이미지가 있으면 모두 추가
            if (req.getImageUrls() != null) {
                req.getImageUrls().forEach(url ->
                        r.getReviewImages().add(
                                ReviewImage.builder().imageUrl(url).build()
                        )
                );
            }
            return reviewRepo.save(r);}
}
