package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.TryMission;
import umc.spring.domain.TryMissionId;

import java.util.Optional;

public interface TryMissionRepository extends JpaRepository<TryMission, TryMissionId> {

    boolean existsByMember_IdAndMission_Id(Long memberId, Long missionId);

    Optional<TryMission> findByMember_IdAndMission_Id(Long memberId, Long missionId);
}
