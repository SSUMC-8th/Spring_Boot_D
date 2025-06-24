package umc.spring.service.userservice;

import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.apiPayload.status.ErrorResponse;
import umc.spring.config.jwt.JwtTokenProvider;
import umc.spring.converter.UserConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.User;
import umc.spring.repository.userrepository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;

import lombok.extern.slf4j.Slf4j;
import umc.spring.web.dto.UserResponseDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public User join(UserRequestDTO.JoinDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        log.info("📥 회원가입 요청 - email: {}", request.getEmail());
        log.info("📦 성별: {}, 생년월일: {}-{}-{}", request.getGender(), request.getBirthYear(), request.getBirthMonth(), request.getBirthDay());
        log.info("📦 카테고리: {}", request.getPreferCategory());

        User user = UserConverter.toUser(request);
        user.encodePassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);

        log.info("✅ 저장 완료 - userId: {}", savedUser.getId());

        return savedUser;
    }

    @Override
    public UserResponseDTO.LoginResultDTO loginMember(UserRequestDTO.LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new UserHandler(ErrorResponse.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UserHandler(ErrorResponse.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(), null,
                Collections.singleton(() -> user.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return UserConverter.toLoginResultDTO(
                user.getId(),
                accessToken
        );
    }
}
