package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.ReviewRequestDTO;
import umc.spring.apiPayload.code.ReviewResponseDTO;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.validation.annotation.ExistStore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO> addReview(
            @PathVariable @ExistStore Long storeId,
            @RequestBody @Valid ReviewRequestDTO request) {

        ReviewResponseDTO response = reviewService.addReview(storeId, request);
        return ApiResponse.onSuccess(response);
    }
}