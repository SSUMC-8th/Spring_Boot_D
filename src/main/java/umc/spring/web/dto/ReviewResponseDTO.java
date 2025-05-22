package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

public class ReviewResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class CreateResult {
        private Long reviewId;
        private String restaurantName;
        private Instant createdAt;
    }
}
