package umc.spring.service.MemberService;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, @Nullable MissionStatus missionStatus, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> memberMissionPage;
        if (missionStatus == null) {
            memberMissionPage = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
            return memberMissionPage;
        } else {
            memberMissionPage = memberMissionRepository.findAllByMemberAndMissionStatus(member, missionStatus, PageRequest.of(page, 10));
            return memberMissionPage;
        }
    }
}
