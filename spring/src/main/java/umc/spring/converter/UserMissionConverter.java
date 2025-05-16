package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.usermission.UserMissionResponse;

@Component
public class UserMissionConverter {
    public UserMissionResponse toResponse(UserMission um) {
        return new UserMissionResponse(um.getMissionStatus().name());
    }
}