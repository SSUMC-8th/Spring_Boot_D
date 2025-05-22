package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.ChallengeService;
import umc.spring.validation.annotation.MissionNotDuplicated;
import umc.spring.web.dto.ChallengeResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<ChallengeResponseDTO> challengeMission(
            @PathVariable @MissionNotDuplicated Long missionId) {

        ChallengeResponseDTO response = challengeService.challengeMission(missionId);
        return ApiResponse.onSuccess(response);
    }
}