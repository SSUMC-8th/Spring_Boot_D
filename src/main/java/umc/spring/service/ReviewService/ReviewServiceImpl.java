package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import umc.spring.domain.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewImageRepository reviewImageRepository;

    // 📌 리뷰 작성 API
    @Override
    @Transactional
    public ReviewResponseDTO addReview(Long storeId, ReviewRequestDTO request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 가게입니다."));

        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다."));

        Review review = ReviewConverter.toReviewEntity(request, member, store);
        reviewRepository.save(review);

        List<ReviewImage> reviewImages = ReviewConverter.toReviewImageList(request.getImg(), review);
        reviewImageRepository.saveAll(reviewImages);

        return ReviewConverter.toResponseDTO(review);
    }

    // ✅ "내가 작성한 리뷰 목록 조회" API용 서비스 메서드
    @Override
    public Page<Review> getMyReviews(Long memberId, int page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        PageRequest pageable = PageRequest.of(page, 10);
        return reviewRepository.findAllByMember(member, pageable);
    }
}