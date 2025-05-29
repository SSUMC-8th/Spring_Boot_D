package umc.spring.web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.apipayload.validation.ExistingStore;
import umc.spring.apipayload.validation.PageVaild;
import umc.spring.converter.ReviewConverter;
import umc.spring.service.review.ReviewService;
import umc.spring.web.dto.review.AddReviewRequest;
import umc.spring.web.dto.review.AddReviewResponse;
import umc.spring.web.dto.review.ReviewListResponse;

@Validated
@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewConverter converter;

    // 리뷰 작성 API
    @PostMapping("/{storeId}/reviews")
    public ResponseEntity<ApiResponse<AddReviewResponse>> addReview(
            @ExistingStore
            @NotNull @PathVariable("storeId") Long storeId,
            @Valid @RequestBody AddReviewRequest req
    ) {
        var review = reviewService.addReview(storeId, req);
        var dto = converter.toResponse(review);
        return ResponseEntity
                .status(201)
                .body(ApiResponse.onSuccess(dto));
    }

    // 리뷰 목록 조회 API
    @GetMapping("/{storeId}/reviews")
    public ApiResponse<Page<ReviewListResponse>> getReviews(
            @ExistingStore @PathVariable("storeId") Long storeId,

            @RequestParam("page") @PageVaild Integer page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page - 1, size); // page-1 처리
        var result = reviewService.getReviews(storeId, pageable);
        return ApiResponse.onSuccess(result);
    }

}
