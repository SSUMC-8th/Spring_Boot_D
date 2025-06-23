// 파일 위치: umc.spring.web.dto.UserRequestDTO.java
package umc.spring.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Role;

@Getter
@Setter
public class UserRequestDTO {

    @Getter
    @Setter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotBlank
        @Email
        String email;    // 이메일 필드 추가
        @NotBlank
        String password;    // 비밀번호 필드 추가
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        String address;
        List<Long> preferCategory;
        @NotNull
        Role role;    // 역할 필드 추가
        String specAddress;
    }
    }

