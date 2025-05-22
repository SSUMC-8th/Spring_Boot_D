package umc.spring.apiPayload.code;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Getter
public class ReviewRequestDTO {

    @Schema(description = "리뷰 점수 (1~5점)", example = "4.5")
    @Min(value = 1, message = "최소 점수는 1점입니다.")
    @Max(value = 5, message = "최대 점수는 5점입니다.")
    private float score;

    @Schema(description = "리뷰 본문", example = "정말 맛있었어요!")
    @NotBlank(message = "리뷰 본문을 입력해주세요.")
    private String text;

    @Schema(description = "이미지 URL 목록", example = "[\"https://s3.img1.jpg\", \"https://s3.img2.jpg\"]")
    private List<String> img;
}