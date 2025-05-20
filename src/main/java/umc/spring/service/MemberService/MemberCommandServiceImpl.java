package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.converter.FavoriteFoodConverter;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Food;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.FavoriteFood;
import umc.spring.repository.FoodRepository.FoodRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.MemberJoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<Food> foodList = request.getPreferCategory().stream()
                .map(category ->  {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<FavoriteFood> favoriteFoodList = FavoriteFoodConverter.toFavoriteFoodList(foodList);

        favoriteFoodList.forEach(favoriteFood -> {favoriteFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}