package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Mission;
import umc.spring.web.dto.mission.AddMissionResponse;

@Component
public class MissionConverter {
    public AddMissionResponse toResponse(Mission mission) {
        return new AddMissionResponse(mission.getId());
    }
}
