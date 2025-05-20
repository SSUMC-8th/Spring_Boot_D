package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review writeReview(ReviewRequestDTO.CreateReview request) {

        // 실제 사용자의 인증 정보가 있다면 여기에 반영
        Member member = memberRepository.findById(1L)  // 임시로 memberId=1 사용
                .orElseThrow(() -> new RuntimeException("MEMBER_NOT_FOUND"));

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("RESTAURANT_NOT_FOUND"));

        Review review = ReviewConverter.toReview(request, member, restaurant);

        return reviewRepository.save(review);
    }
}
