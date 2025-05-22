package umc.spring.service.RestaurantService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.web.dto.RestaurantRequestDTO;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RegionRepository regionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Restaurant addRestaurant(RestaurantRequestDTO request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST)); // 예외 커스터마이징 가능

        Restaurant restaurant = RestaurantConverter.toRestaurant(request, region);
        return restaurantRepository.save(restaurant);
    }
}
