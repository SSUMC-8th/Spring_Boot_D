package umc.spring.service.userservice;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.UserConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.User;
import umc.spring.repository.userrepository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
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
}
