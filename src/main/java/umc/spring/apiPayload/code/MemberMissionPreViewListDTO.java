package umc.spring.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberMissionPreViewListDTO {
    private boolean isLast;
    private boolean isFirst;
    private int totalPages;
    private long totalElements;
    private int listSize;
    private List<MemberMissionPreViewDTO> memberMissionList;
}