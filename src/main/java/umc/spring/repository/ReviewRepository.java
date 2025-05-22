package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewId;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMember_Id(Long memberId);
    List<Review> findByRestaurant_Id(Long restaurantId);
}

