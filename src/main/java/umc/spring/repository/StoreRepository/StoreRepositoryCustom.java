package umc.spring.repository.StoreRepository;

import umc.spring.domain.Restaurant;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score);
}
