package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.exception.GeneralException;
import umc.spring.apipayload.status.ErrorResponse;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.mission.AddMissionRequest;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final StoreRepository storeRepo;
    private final MissionRepository missionRepo;

    @Transactional
    public Mission addMission(AddMissionRequest req) {
        Store store = storeRepo.findById(req.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorResponse.STORE_NOT_FOUND));

        Mission mission = Mission.builder()
                .store(store)
                .requirements(req.getRequirements())
                .points(req.getPoints())
                .dueAt(req.getDueAt())
                .build();

        return missionRepo.save(mission);
    }
}
