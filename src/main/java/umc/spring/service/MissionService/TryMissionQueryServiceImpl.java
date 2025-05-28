package umc.spring.service.MissionService;

import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.domain.Member;
import umc.spring.domain.TryMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.TryMissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TryMissionQueryServiceImpl implements TryMissionQueryService {

    private final TryMissionRepository tryMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Page<TryMission> getMyInProgressMissions(Long memberId, Pageable pageable) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        return tryMissionRepository.findAllByMemberIdAndStatus(member.getId(), "inprogress", pageable);
    }
}
