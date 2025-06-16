package umc.spring.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {
    @Getter
    @Setter
    public static class MemberJoinDto {
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        @ExistCategories
        List<Long> preferCategory;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Role role;
    }
}