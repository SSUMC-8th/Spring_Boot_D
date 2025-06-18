package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.exception.GeneralException;
import umc.spring.apipayload.status.ErrorResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.domain.Store;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.review.AddReviewRequest;
import umc.spring.web.dto.review.ReviewListResponse;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final StoreRepository storeRepo;
    private final ReviewRepository reviewRepo;
    private final ReviewConverter reviewConverter;

    @Transactional
    public Review addReview(Long storeId, AddReviewRequest req) {
        Store store = storeRepo.findById(storeId)
                .orElseThrow(() -> new GeneralException(ErrorResponse.STORE_NOT_FOUND));

        Review r = Review.builder()
                .content(req.getContent())
                .star(req.getStar())
                .store(store)
                .build();

        // 연관된 이미지가 있으면 모두 추가
        if (req.getImageUrls() != null) {
            req.getImageUrls().forEach(url ->
                    r.getReviewImages().add(
                            ReviewImage.builder().imageUrl(url).build()
                    )
            );
        }
        return reviewRepo.save(r);
    }


    @Transactional(readOnly = true)
    public Page<ReviewListResponse> getReviews(Long storeId, Pageable pageable) {
        Store store = storeRepo.findById(storeId)
                .orElseThrow(() -> new GeneralException(ErrorResponse.STORE_NOT_FOUND));

        Page<Review> reviewPage = reviewRepo.findAllByStore(store, pageable);

        return reviewPage.map(reviewConverter::toReviewListResponse);
    }

}
