package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    public static class MemberMissionJoinResultDTO {
        private Long memberMissionId;
        private LocalDateTime createdAt;
    }
}
