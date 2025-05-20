package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import umc.spring.domain.TryMission;

import java.time.Instant;

public class TryMissionResponseDTO {

    @Getter
    @Builder
    public static class TryResult {
        private Long missionId;
        private String status;
        private Instant createdAt;

        public static TryResult from(TryMission entity) {
            return TryResult.builder()
                    .missionId(entity.getMission().getId())
                    .status(entity.getStatus())
                    .createdAt(entity.getCreatedAt())
                    .build();
        }
    }
}
