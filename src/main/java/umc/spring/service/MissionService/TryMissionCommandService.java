package umc.spring.service.MissionService;

import umc.spring.domain.TryMission;

public interface TryMissionCommandService {
    TryMission tryMission(Long memberId, Long missionId);
    void completeMission(Long memberId, Long missionId);
}
