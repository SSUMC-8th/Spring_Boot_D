package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.TryMission;

public interface TryMissionQueryService {
    Page<TryMission> getMyInProgressMissions(Long memberId, Pageable pageable);
}
