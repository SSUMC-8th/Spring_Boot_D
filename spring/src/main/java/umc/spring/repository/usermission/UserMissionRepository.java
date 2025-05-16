package umc.spring.repository.usermission;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByUser_IdAndMission_Id(Long userId, Long missionId);
}
