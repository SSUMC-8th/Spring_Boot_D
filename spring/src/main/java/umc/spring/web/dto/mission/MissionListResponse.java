package umc.spring.web.dto.mission;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionListResponse {
    private Long missionId;
    private String requirements;
    private int points;
    private LocalDateTime dueAt;
    private String storeName;
}

