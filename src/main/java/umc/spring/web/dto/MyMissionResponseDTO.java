package umc.spring.web.dto;

import lombok.*;

import java.time.Instant;
import java.util.List;

public class MyMissionResponseDTO {

    @Getter
    @Builder
    public static class MyMissionDTO {
        private Long missionId;
        private String restaurantName;
        private Long cost;
        private Long point;
        private Instant deadline;
    }

    @Getter
    @Builder
    public static class MyMissionListDTO {
        private List<MyMissionDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}
