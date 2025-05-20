package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.NotDuplicatedMemberMission;

public class MemberMissionRequestDTO {

    @Getter
    @NotDuplicatedMemberMission
    public static class MemberMissionJoinDTO {

        @NotNull
        private Long memberId;

        @NotNull
        private Long missionId;
    }
}
