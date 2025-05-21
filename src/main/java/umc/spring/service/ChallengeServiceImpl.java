package umc.spring.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.ChallengeResponseDTO;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final umc.spring.domain.repository.MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public ChallengeResponseDTO challengeMission(Long missionId) {

        // 1. 미션 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("미션이 존재하지 않습니다."));

        // 2. 하드코딩된 멤버 조회 (id = 1)
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("멤버가 존재하지 않습니다."));

        // 3. MemberMission 생성 및 저장
        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .isCompleted(false)
                .build();

        memberMissionRepository.save(memberMission);

        // 4. 응답 DTO 생성 및 반환
        return ChallengeResponseDTO.builder()
                .memberMissionId(memberMission.getId())
                .challengedAt(memberMission.getCreatedAt())  // BaseEntity에서 관리된다면
                .build();
    }
}