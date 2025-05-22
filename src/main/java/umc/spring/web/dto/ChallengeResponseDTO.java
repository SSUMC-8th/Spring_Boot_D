package umc.spring.web.dto;

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
public class ChallengeResponseDTO {

    @Schema(description = "멤버-미션 관계 ID", example = "10")
    private Long memberMissionId;

    @Schema(description = "도전 시작 시각", example = "2024-05-21T18:00:00")
    private LocalDateTime challengedAt;
}