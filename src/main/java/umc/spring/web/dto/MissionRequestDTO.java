package umc.spring.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

public class MissionRequestDTO {

    @Getter
    public static class CreateMission {

        @NotNull(message = "가게 ID는 필수입니다.")
        private Long restaurantId;

        @NotNull(message = "미션 마감일은 필수입니다.")
        @Future(message = "마감일은 현재 시각보다 이후여야 합니다.")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private Instant deadline;

        @NotNull(message = "금액은 필수입니다.")
        @Min(value = 1, message = "금액은 1원 이상이어야 합니다.")
        private Long cost;

        @NotNull(message = "포인트는 필수입니다.")
        @Min(value = 1, message = "포인트는 1 이상이어야 합니다.")
        private Long point;
    }
}
