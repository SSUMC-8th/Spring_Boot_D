package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.ReviewRequestDTO;
import umc.spring.apiPayload.code.ReviewResponseDTO;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.domain.Store;
import umc.spring.repository.ReiviewRepository.ReviewRepository;
import umc.spring.repository.ReviewImageRepository.ReviewImageRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final umc.spring.domain.repository.MemberRepository memberRepository;
    private final ReviewImageRepository reviewImageRepository;

    @Override
    @Transactional
    public ReviewResponseDTO addReview(Long storeId, ReviewRequestDTO request) {
        // 1. 가게 존재 확인
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 가게입니다."));

        // 2. 하드코딩된 유저 조회
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다."));

        // 3. 리뷰 생성 및 저장
        Review review = ReviewConverter.toReviewEntity(request, member, store);
        reviewRepository.save(review);

        // 4. 이미지가 있다면 저장
        List<ReviewImage> reviewImages = ReviewConverter.toReviewImageList(request.getImg(), review);
        reviewImageRepository.saveAll(reviewImages);

        // 5. 응답 DTO 반환
        return ReviewConverter.toResponseDTO(review);
    }
}