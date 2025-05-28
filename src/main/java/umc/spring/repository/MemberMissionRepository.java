package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.apiPayload.code.MissionStatus;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
    Page<MemberMission> findAllByMemberAndMissionStatus(Member member, MissionStatus status, PageRequest pageRequest);
}
