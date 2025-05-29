package umc.spring.web.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionDTO {
    private Long id;
    private Long cost;
    private Long point;
    private Instant deadline;
}
