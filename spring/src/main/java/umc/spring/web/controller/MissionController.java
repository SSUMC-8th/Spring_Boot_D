package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.service.mission.MissionService;
import umc.spring.web.dto.mission.AddMissionRequest;
import umc.spring.web.dto.mission.AddMissionResponse;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;
    private final MissionConverter converter;

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
}