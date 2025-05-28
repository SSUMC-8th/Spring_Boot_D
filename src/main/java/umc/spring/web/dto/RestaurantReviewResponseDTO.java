package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class RestaurantReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewListDTO {
        private List<ReviewPreviewDTO> reviewList;
        private Integer listSize;        // 현재 페이지의 리뷰 수
        private Integer totalPage;       // 전체 페이지 수
        private Long totalElements;      // 전체 리뷰 수
        private Boolean isFirst;         // 첫 페이지 여부
        private Boolean isLast;          // 마지막 페이지 여부
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewDTO {
        private String nickname;         // 리뷰 작성자 닉네임
        private Integer rating;          // 별점 (1~5)
        private String content;          // 리뷰 본문
        private LocalDateTime createdAt; // 리뷰 작성일
    }
}
