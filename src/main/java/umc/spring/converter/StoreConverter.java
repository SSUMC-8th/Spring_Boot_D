package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store toStoreEntity(StoreRequestDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                //.description(request.getDescription())
                .region(region)
                .build();
    }

    public static StoreResponseDTO toResponseDTO(Store store) {
        return StoreResponseDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())  // BaseEntity가 처리 중이면 이대로
                .build();
    }


}