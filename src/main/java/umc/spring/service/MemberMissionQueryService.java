package umc.spring.service;

import org.springframework.data.domain.Page;
import umc.spring.apiPayload.code.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> getMemberMissionList(Long memberId, MissionStatus missionStatus, Integer page);
}