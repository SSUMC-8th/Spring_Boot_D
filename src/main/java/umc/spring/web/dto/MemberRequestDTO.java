package umc.spring.web.dto;

import lombok.Getter;

import java.util.Collection;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto {
        private String name;
        private String gender;
        private Integer birthYear;
        private Integer birthMonth;
        private Integer birthDay;
        private String address;
        private String specAddress;
        private String email;
        private String platform;
        private Integer phoneNum;
        private List<Long> preferCategory;

    }
}