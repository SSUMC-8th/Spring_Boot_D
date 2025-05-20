package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RestaurantHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewPicture;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository restaurantRepository;


    @Override
    @Transactional
    public Review joinReview(Long restaurantId, ReviewRequestDTO.ReviewJoinDTO request) {

        Review newReview = ReviewConverter.toReview(request);

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        newReview.setRestaurant(restaurant);

        List<ReviewPicture> pictureList = request.getReviewPictureList().stream()
                        .map(url -> ReviewPicture.builder()

                                .imageUrl(url)
                                .build())
                                .collect(Collectors.toList());

        for (ReviewPicture picture : pictureList) {
            newReview.setReviewPicture(picture);
        }

        return reviewRepository.save(newReview);
    }

}
