package umc.spring.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import io.swagger.v3.oas.annotations.media.Schema;
import umc.spring.validation.annotation.ExistCategories;

import java.util.Collection;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto {

        @NotBlank
        @Size(min = 2, max = 10)
//        @Schema(description = "사용자 이름", example = "홍길동")
        private String name;

        @NotBlank
//        @Schema(description = "성별", example = "남성")
        private String gender;

        @NotNull
        @Min(1900) @Max(2100)
//        @Schema(description = "태어난 해", example = "1998")
        private Integer birthYear;

        @NotNull
        @Min(1) @Max(12)
//        @Schema(description = "태어난 달", example = "3")
        private Integer birthMonth;

        @NotNull
        @Min(1) @Max(31)
//        @Schema(description = "태어난 일", example = "12")
        private Integer birthDay;

        @NotBlank
        @Size(min = 5, max = 100)
//        @Schema(description = "주소", example = "서울특별시 성동구 왕십리로 222")
        private String address;

        @NotBlank
        @Size(min = 5, max = 100)
//        @Schema(description = "상세 주소", example = "101동 1001호")
        private String specAddress;

        @Email
        @NotBlank
//        @Schema(description = "이메일", example = "hong@example.com")
        private String email;

//        @Schema(description = "회원 상태", example = "active")
        private String status; // 기본값은 서버에서 처리해도 되므로 필수 아님

        @NotBlank
//        @Schema(description = "소셜 플랫폼", example = "KAKAO")
        private String platform;

        @NotNull
        @Min(1000000000) // 10자리 이상
        @Max(99999999999L) // 11자리 이하
//        @Schema(description = "전화번호", example = "01012345678")
        private Integer phoneNum;

        @NotEmpty
        @ExistCategories
        @Schema(description = "선호 음식 카테고리 ID 목록", example = "[1, 2, 3]")
        private List<Long> preferCategory;

    }
}