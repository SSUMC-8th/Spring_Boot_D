package umc.spring.service.userservice;

import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

public interface UserCommandService {
    User join(UserRequestDTO.JoinDto request);
    UserResponseDTO.LoginResultDTO loginMember(UserRequestDTO.LoginRequestDTO request);
}


