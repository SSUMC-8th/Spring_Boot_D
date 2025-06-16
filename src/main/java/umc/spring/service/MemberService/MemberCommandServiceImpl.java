package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.config.security.jwt.JwtTokenProvider;
import umc.spring.converter.FavoriteFoodConverter;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Food;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.FavoriteFood;
import umc.spring.repository.FoodRepository.FoodRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.MemberJoinDto request) {

        Member newMember = MemberConverter.toMember(request);

        newMember.encodePassword(passwordEncoder.encode(request.getPassword())); // 암호화

        List<Food> foodList = request.getPreferCategory().stream()
                .map(category ->  {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<FavoriteFood> favoriteFoodList = FavoriteFoodConverter.toFavoriteFoodList(foodList);

        favoriteFoodList.forEach(favoriteFood -> {favoriteFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new MemberHandler(ErrorStatus.INVALID_TOKEN);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                member.getEmail(), null, Collections.singleton(() -> member.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return MemberConverter.toLoginResultDTO(
                member.getId(),
                accessToken
        );
    }
}