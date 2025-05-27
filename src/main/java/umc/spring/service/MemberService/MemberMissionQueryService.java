package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionQueryService {

    Page<MemberMission> getMemberMissionList(Long memberId, MissionStatus missionStatus, Integer page);
}
