package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.TryMission;
import umc.spring.service.MissionService.TryMissionCommandService;
import umc.spring.web.dto.TryMissionRequestDTO;
import umc.spring.web.dto.TryMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class TryMissionController {

    private final TryMissionCommandService tryMissionCommandService;

    @PostMapping("/try")
    public ApiResponse<TryMissionResponseDTO.TryResult> tryMission(@RequestBody @Valid TryMissionRequestDTO.CreateTry request) {
        TryMission tryMission = tryMissionCommandService.tryMission(
                request.getMemberId(),
                request.getMissionId()
        );

        return ApiResponse.onSuccess(TryMissionResponseDTO.TryResult.from(tryMission));
    }
}

