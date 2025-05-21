package umc.spring.service.StoreService;

import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public interface StoreService {
    StoreResponseDTO createStore(Long regionId, StoreRequestDTO request);
}