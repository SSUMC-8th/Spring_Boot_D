package umc.spring.apipayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.apipayload.code.BaseResponse;
import umc.spring.apipayload.status.SuccessResponse;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess","code","message","result"})
public class ApiResponse<T> {
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T result;

    // 성공한 경우 응답 생성
    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccessResponse._OK.buildDto().getCode(),SuccessResponse._OK.buildDto().getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseResponse code, T result){
            return new ApiResponse<>(true, code.buildDtoWithHttpStatus().getCode(), code.buildDtoWithHttpStatus().getMessage(), result);
    }

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(false,code,message,data);
    }

}
