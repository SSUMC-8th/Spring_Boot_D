package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.exception.GeneralException;
import umc.spring.apipayload.status.ErrorResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.repository.user.UserRepository;
import umc.spring.repository.usermission.UserMissionRepository;
import umc.spring.service.usermission.UserMissionService;
import umc.spring.web.dto.mission.AddMissionRequest;
import umc.spring.web.dto.mission.MissionListResponse;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final StoreRepository storeRepo;
    private final UserRepository userRepo;
    private final MissionRepository missionRepo;
    private final UserMissionRepository userMissionRepo;
    private final MissionConverter converter;

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

    @Transactional(readOnly = true)
    public Page<MissionListResponse> getMissionsByStore(Long storeId, Pageable pageable) {
        return missionRepo.findAllByStoreId(storeId, pageable)
                .map(converter::toMissionListResponse);
    }

}
