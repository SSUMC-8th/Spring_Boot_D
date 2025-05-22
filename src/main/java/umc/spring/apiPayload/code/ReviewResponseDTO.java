package umc.spring.apiPayload.code;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDTO {

    @Schema(description = "리뷰 ID", example = "15")
    private Long reviewId;

    @Schema(description = "작성 시간", example = "2024-05-21T15:33:00")
    private LocalDateTime createdAt;
}