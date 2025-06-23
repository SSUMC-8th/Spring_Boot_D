package umc.spring.service.userservice;

import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;

public interface UserCommandService {
    User join(UserRequestDTO.JoinDto request);
}


