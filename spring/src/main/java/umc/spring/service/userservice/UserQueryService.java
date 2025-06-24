package umc.spring.service.userservice;

import jakarta.servlet.http.HttpServletRequest;
import umc.spring.web.dto.UserResponseDTO;

public interface UserQueryService {
    UserResponseDTO.UserInfoDTO getMemberInfo(HttpServletRequest request);
}
