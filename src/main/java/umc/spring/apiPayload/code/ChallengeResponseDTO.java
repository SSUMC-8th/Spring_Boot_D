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
public class ChallengeResponseDTO {

    @Schema(description = "도전한 미션과 멤버 관계 ID", example = "33")
    private Long memberMissionId;

    @Schema(description = "도전 시작 시간", example = "2024-05-21T17:12:45")
    private LocalDateTime challengedAt;
}