package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.ReviewRequestDTO;
import umc.spring.apiPayload.code.ReviewResponseDTO;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.validation.annotation.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 작성 API
    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO> addReview(
            @PathVariable @ExistStore Long storeId,
            @RequestBody @Valid ReviewRequestDTO request) {
        ReviewResponseDTO response = reviewService.addReview(storeId, request);
        return ApiResponse.onSuccess(response);
    }

    // 내가 작성한 리뷰 목록 조회 API
    @GetMapping("/members/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회", description = "특정 memberId가 작성한 리뷰를 페이징하여 반환합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "회원 없음")
    })
    public ApiResponse<ReviewResponseDTO.MyReviewListDTO> getMyReviews(
            @Parameter(description = "회원 ID") @PathVariable(name = "memberId") Long memberId,
            @Parameter(description = "페이지 번호(1부터 시작)") @ValidPage @RequestParam(name = "page") Integer page) {

        Page<Review> reviewPage = reviewService.getMyReviews(memberId, page);
        return ApiResponse.onSuccess(ReviewConverter.toMyReviewListDTO(reviewPage));
    }
}