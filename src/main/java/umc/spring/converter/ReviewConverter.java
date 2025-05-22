package umc.spring.converter;

import umc.spring.apiPayload.code.ReviewRequestDTO;
import umc.spring.apiPayload.code.ReviewResponseDTO;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.domain.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    /**
     * DTO → Review 엔티티
     */
    public static Review toReviewEntity(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .body(dto.getText())
                .score(dto.getScore())
                .member(member)
                .store(store)
                .build();
    }

    /**
     * 이미지 URL 리스트 → ReviewImage 엔티티 리스트
     */
    public static List<ReviewImage> toReviewImageList(List<String> urls, Review review) {
        if (urls == null) return new ArrayList<>();

        return urls.stream()
                .map(url -> ReviewImage.builder()
                        .imageUrl(url)
                        .review(review)
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * Review 엔티티 → 응답 DTO
     */
    public static ReviewResponseDTO toResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}