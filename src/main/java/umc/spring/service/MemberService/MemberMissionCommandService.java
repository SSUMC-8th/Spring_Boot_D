package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    @Transactional
    MemberMission joinMission(MemberMissionRequestDTO.MemberMissionJoinDTO request);
//    MemberMission joinMission(MemberMissionRequestDTO.JoinDTO request);
}
