package umc.spring.apiPayload.code;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

public class MissionResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionPreViewDTO {

        @Schema(description = "미션 ID", example = "3")
        private Long missionId;

        @Schema(description = "미션 가격", example = "8000")
        private Integer price;

        @Schema(description = "미션 포인트", example = "500")
        private Integer point;

        @Schema(description = "남은 일수", example = "3")
        private Integer remainDate;

        @Schema(description = "가게 이름", example = "요아정")
        private String storeName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionPreViewListDTO {

        private List<MissionPreViewDTO> missionList;
        private Integer listSize;
        private Integer totalPages;
        private Boolean isFirst;
        private Boolean isLast;
    }
}