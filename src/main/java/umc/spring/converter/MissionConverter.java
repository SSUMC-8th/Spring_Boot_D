package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.MissionDTO;
import umc.spring.web.dto.MissionListDTO;
import umc.spring.web.dto.MissionRequestDTO;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionDTO toDTO(Mission mission) {
        return MissionDTO.builder()
                .id(mission.getId())
                .cost(mission.getCost())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MissionListDTO toListDTO(Page<Mission> page) {
        List<MissionDTO> missions = page.getContent().stream()
                .map(MissionConverter::toDTO)
                .collect(Collectors.toList());

        return MissionListDTO.builder()
                .missions(missions)
                .listSize(missions.size())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }
}

