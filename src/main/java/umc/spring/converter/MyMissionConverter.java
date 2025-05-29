package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.TryMission;
import umc.spring.web.dto.MyMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MyMissionConverter {

    public static MyMissionResponseDTO.MyMissionDTO toMyMissionDTO(TryMission tryMission) {
        return MyMissionResponseDTO.MyMissionDTO.builder()
                .missionId(tryMission.getMission().getId())
                .restaurantName(tryMission.getMission().getRestaurant().getRestaurantName())
                .cost(tryMission.getMission().getCost())
                .point(tryMission.getMission().getPoint())
                .deadline(tryMission.getMission().getDeadline())
                .build();
    }

    public static MyMissionResponseDTO.MyMissionListDTO toMyMissionListDTO(Page<TryMission> tryMissionPage) {
        List<MyMissionResponseDTO.MyMissionDTO> dtoList = tryMissionPage.getContent().stream()
                .map(MyMissionConverter::toMyMissionDTO)
                .collect(Collectors.toList());

        return MyMissionResponseDTO.MyMissionListDTO.builder()
                .missionList(dtoList)
                .listSize(tryMissionPage.getNumberOfElements())
                .totalPage(tryMissionPage.getTotalPages())
                .totalElements(tryMissionPage.getTotalElements())
                .isFirst(tryMissionPage.isFirst())
                .isLast(tryMissionPage.isLast())
                .build();
    }
}
