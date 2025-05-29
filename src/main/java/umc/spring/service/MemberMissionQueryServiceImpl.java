package umc.spring.service;

import io.micrometer.common.lang.Nullable;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.MissionStatus;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final umc.spring.domain.repository.MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, @Nullable MissionStatus missionStatus, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));

        if (missionStatus == null) {
            return memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
        } else {
            return memberMissionRepository.findAllByMemberAndMissionStatus(member, missionStatus, PageRequest.of(page, 10));
        }
    }
}
