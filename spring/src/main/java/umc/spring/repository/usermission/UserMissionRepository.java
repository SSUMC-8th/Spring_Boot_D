package umc.spring.repository.usermission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    // 유저가 해당 미션에 참여 중인지 여부 확인
    boolean existsByUser_IdAndMission_Id(Long userId, Long missionId);

    // 진행 중인 미션 조회 (페이징)
    Page<UserMission> findAllByUserAndMissionStatus(User user, MissionStatus missionStatus, Pageable pageable);
}
