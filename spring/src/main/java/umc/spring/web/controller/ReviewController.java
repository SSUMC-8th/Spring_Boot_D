package umc.spring.web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.apipayload.validation.ExistingStore;
import umc.spring.converter.ReviewConverter;
import umc.spring.service.review.ReviewService;
import umc.spring.web.dto.review.AddReviewRequest;
import umc.spring.web.dto.review.AddReviewResponse;

@Validated
@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewConverter converter;

    @PostMapping("/{storeId}/reviews")
    public ResponseEntity<ApiResponse<AddReviewResponse>> addReview(
            @ExistingStore                       // ← 가게 존재 검증
            @NotNull @PathVariable Long storeId, // PathVariable 검증도 함께
            @Valid @RequestBody AddReviewRequest req
    ) {
        var review = reviewService.addReview(storeId, req);
        var dto    = converter.toResponse(review);
        return ResponseEntity
                .status(201)
                .body(ApiResponse.onSuccess(dto));
    }
}
