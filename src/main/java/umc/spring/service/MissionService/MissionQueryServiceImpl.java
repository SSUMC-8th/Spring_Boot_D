package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getMissionList(Long restaurantId, Integer page) {

        Restaurant restaurant = storeRepository.findById(restaurantId).get();

        Page<Mission> MissionPage = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page,10));
        return MissionPage;
    }
}
