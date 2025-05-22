package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public StoreResponseDTO createStore(Long regionId, StoreRequestDTO request) {

        // 1. 지역 존재 여부 확인
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("해당 지역이 존재하지 않습니다."));

        // 2. Store 엔티티 생성 및 저장
        Store store = StoreConverter.toStoreEntity(request, region);
        storeRepository.save(store);

        // 3. 응답 DTO 반환
        return StoreConverter.toResponseDTO(store);
    }
}