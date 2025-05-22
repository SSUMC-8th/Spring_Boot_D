package umc.spring.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRestaurant;

import java.util.List;


public class ReviewRequestDTO {
    @Getter
    public static class CreateReview {
        @ExistRestaurant(message = "존재하지 않는 식당입니다.")
        @NotNull(message = "restaurantId는 필수입니다.")
        private Long restaurantId;

        @NotNull(message = "missionId는 필수입니다.")
        private Long missionId;

        @NotBlank(message = "리뷰 내용을 입력해주세요.")
        private String content;

        @NotNull(message = "평점을 입력해주세요.")
        @Min(value = 1, message = "평점은 최소 1점입니다.")
        @Max(value = 5, message = "평점은 최대 5점입니다.")
        private Integer rating;

        @Size(max = 5, message = "사진은 최대 5장까지 업로드할 수 있습니다.")
        private List<String> photoUrl;
    }
}
