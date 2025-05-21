package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.StoreService.StoreService;
import umc.spring.validation.annotation.RegionExists;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/{regionId}/stores")
    public ApiResponse<StoreResponseDTO> createStore(
            @PathVariable @RegionExists Long regionId,
            @RequestBody @Valid StoreRequestDTO request) {

        StoreResponseDTO response = storeService.createStore(regionId, request);
        return ApiResponse.onSuccess(response);
    }
}