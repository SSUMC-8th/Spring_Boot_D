package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.TryMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.TryMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.TryMissionRepository;

@Service
@RequiredArgsConstructor
public class TryMissionCommandServiceImpl implements TryMissionCommandService {

    private final TryMissionRepository tryMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public TryMission tryMission(Long memberId, Long missionId) {

        // 1. 중복 도전 방지
        boolean alreadyTried = tryMissionRepository.existsByMember_IdAndMission_Id(memberId, missionId);
        if (alreadyTried) {
            throw new GeneralException(ErrorStatus.ALREADY_TRIED_MISSION);
        }

        // 2. Member 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        // 3. Mission 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        // 4. TryMission 생성 및 저장
        TryMission tryMission = TryMissionConverter.toTryMission(member, mission);
        return tryMissionRepository.save(tryMission);
    }
}
