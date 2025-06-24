package umc.spring.converter;

import java.util.ArrayList;
import umc.spring.domain.User;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;
import umc.spring.web.dto.UserResponseDTO.UserInfoDTO;

public class UserConverter {
    public static User toUser(UserRequestDTO.JoinDto request) {
        Gender gender = null;
        switch (request.getGender()) {
            case 1: gender = Gender.MALE; break;
            case 2: gender = Gender.FEMALE; break;
            case 3: gender = Gender.NONE; break;
        }

        return User.builder()
                .name(request.getName())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .gender(gender)
                .address(request.getAddress())
                .role(request.getRole())   // 추가된 코드
                .preferCategory(new ArrayList<>())
                .birth(String.format("%04d-%02d-%02d",
                        request.getBirthYear(),
                        request.getBirthMonth(),
                        request.getBirthDay()))
                .build();
    }

    public static UserResponseDTO.LoginResultDTO toLoginResultDTO(Long userId, String accessToken) {
        return UserResponseDTO.LoginResultDTO.builder()
                .memberId(userId)
                .accessToken(accessToken)
                .build();
    }

    public static UserResponseDTO.UserInfoDTO toUserInfoDTO(User user) {
        return UserResponseDTO.UserInfoDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender().name()) // Enum → String
                .build();
    }
}