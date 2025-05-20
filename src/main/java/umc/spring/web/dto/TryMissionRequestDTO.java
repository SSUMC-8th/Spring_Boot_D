package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.NotDuplicateMissionChallenge;

@Getter
public class TryMissionRequestDTO {

    @Getter
    @NotDuplicateMissionChallenge // 클래스 레벨에 적용
    public static class CreateTry {

        @NotNull(message = "미션 ID는 필수입니다.")
        private Long missionId;

        @NotNull(message = "식당 ID는 필수입니다.")
        private Long restaurantId;

        @NotNull(message = "회원 ID는 필수입니다.")
        private Long memberId;
    }

}
