package umc.spring.web.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import umc.spring.apipayload.validation.ExistingStore;
import umc.spring.apipayload.validation.PageVaild;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.apipayload.validation.ExistingUser;
import umc.spring.converter.MissionConverter;
import umc.spring.service.mission.MissionService;
import umc.spring.service.usermission.UserMissionService;
import umc.spring.web.dto.mission.AddMissionRequest;
import umc.spring.web.dto.mission.AddMissionResponse;
import umc.spring.web.dto.mission.MissionListResponse;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class MissionController {

    private final MissionService missionService;
    private final MissionConverter converter;
    private final UserMissionService userMissionService;

    @PostMapping("/add-mission")
    public ResponseEntity<ApiResponse<AddMissionResponse>> addMission(
            @Valid @RequestBody AddMissionRequest req
    ) {
        var mission = missionService.addMission(req);
        var resp    = converter.toResponse(mission);
        return ResponseEntity
                .status(201)
                .body(ApiResponse.onSuccess(resp));
    }

    @GetMapping("/users/{userId}/missions/ongoing")
    public ApiResponse<Page<MissionListResponse>> getUserMissions(
            @ExistingUser @PathVariable("userId")  Long userId,
            @RequestParam("page") @PageVaild Integer page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page - 1, size);
        var result= userMissionService.getUserMissions(userId, pageable);
        return ApiResponse.onSuccess(result);
    }

    @GetMapping("/stores/{storeId}/missions")
    public ApiResponse<Page<MissionListResponse>> getMissionsByStore(
            @PathVariable("storeId") @ExistingStore Long storeId,
            @RequestParam("page") @PageVaild Integer page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page - 1, size);
        var result= missionService.getMissionsByStore(storeId, pageable);
        return ApiResponse.onSuccess(result);

    }

}