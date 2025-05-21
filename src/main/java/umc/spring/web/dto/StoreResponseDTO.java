

package umc.spring.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponseDTO {

    @Schema(description = "저장된 가게 ID", example = "10")
    private Long storeId;

    @Schema(description = "생성 시간", example = "2024-05-21T19:30:00")
    private LocalDateTime createdAt;
}