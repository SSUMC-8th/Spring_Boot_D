package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Mission;
import umc.spring.web.dto.mission.AddMissionResponse;
import umc.spring.web.dto.mission.MissionListResponse;

@Component
public class MissionConverter {
    public AddMissionResponse toResponse(Mission mission) {
        return new AddMissionResponse(mission.getId());
    }

    public MissionListResponse toMissionListResponse(Mission mission) {
        return MissionListResponse.builder()
                .missionId(mission.getId())
                .storeName(mission.getStore().getName())
                .points(mission.getPoints())
                .requirements(mission.getRequirements())
                .dueAt(mission.getDueAt())
                .build();
    }
}
