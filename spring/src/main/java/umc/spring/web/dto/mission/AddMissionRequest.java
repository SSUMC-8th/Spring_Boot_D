package umc.spring.web.dto.mission;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddMissionRequest {
    @NotNull
    private Long storeId;

    @NotBlank
    private String requirements;

    @Min(1)
    private int points;

    @NotNull
    @Future
    private LocalDateTime dueAt;
}
