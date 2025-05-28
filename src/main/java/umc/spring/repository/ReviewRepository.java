package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Restaurant;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMember_Id(Long memberId);
    List<Review> findByRestaurant_Id(Long restaurantId);

    Page<Review> findAllByRestaurant(Restaurant restaurant, Pageable pageable);
    Page<Review> findAllByMember(Member member, Pageable pageable);
}

