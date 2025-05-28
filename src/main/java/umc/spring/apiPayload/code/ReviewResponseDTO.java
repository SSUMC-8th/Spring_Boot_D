package umc.spring.apiPayload.code;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDTO {

    @Schema(description = "리뷰 ID", example = "15")
    private Long reviewId;

    @Schema(description = "작성 시간", example = "2024-05-21T15:33:00")
    private LocalDateTime createdAt;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewDTO {
        private String nickname;
        private Float score;
        private String body;
        private LocalDate createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewListDTO {
        private List<MyReviewDTO> reviews;
        private int listSize;
        private int totalPages;
        private long totalElements;
        private boolean isFirst;
        private boolean isLast;
    }
}
