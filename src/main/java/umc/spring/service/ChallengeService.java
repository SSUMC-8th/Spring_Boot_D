package umc.spring.service;


import umc.spring.web.dto.ChallengeResponseDTO;

public interface ChallengeService {
    ChallengeResponseDTO challengeMission(Long missionId);
}