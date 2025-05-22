package umc.spring.web.dto.usermission;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.apipayload.validation.UniqueUserMission;

@Getter
@Setter
@UniqueUserMission
public class UserMissionRequest {
    @NotNull
    @Min(1)
    private Long userId;

    @NotNull @Min(1)
    private Long missionId;
}
