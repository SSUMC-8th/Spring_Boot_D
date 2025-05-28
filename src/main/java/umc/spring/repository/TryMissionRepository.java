package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.TryMission;
import umc.spring.domain.TryMissionId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TryMissionRepository extends JpaRepository<TryMission, TryMissionId> {

    boolean existsByMember_IdAndMission_Id(Long memberId, Long missionId);
//    Optional<TryMission> findByMember_IdAndMission_Id(Long memberId, Long missionId);

    Page<TryMission> findAllByMemberIdAndStatus(Long memberId, String status, Pageable pageable);
    Optional<TryMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
