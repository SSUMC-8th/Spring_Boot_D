package umc.spring.web.dto.mission;

public class AddMissionResponse {
    private Long missionId;

    public AddMissionResponse(Long missionId) {
        this.missionId = missionId;
    }

    public Long getMissionId() {
        return missionId;
    }
}
