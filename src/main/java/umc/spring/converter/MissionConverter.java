package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.MissionRequestDTO;

import java.time.Instant;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateMission dto, Restaurant restaurant) {
        Mission mission = new Mission();
        mission.setRestaurant(restaurant);
        mission.setDeadline(dto.getDeadline());
        mission.setCost(dto.getCost());
        mission.setPoint(dto.getPoint());
        mission.setCreatedAt(Instant.now());
        mission.setUpdatedAt(Instant.now());
        return mission;
    }
}
