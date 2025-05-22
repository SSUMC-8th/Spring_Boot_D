package umc.spring.web.dto.usermission;

import lombok.Getter;

@Getter
public class UserMissionResponse {
    private String status;

    public UserMissionResponse(String status) {
        this.status = status;
    }
}
