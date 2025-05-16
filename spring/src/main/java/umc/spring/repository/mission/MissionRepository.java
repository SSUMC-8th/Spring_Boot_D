package umc.spring.repository.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

}
