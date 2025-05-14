package umc.spring.apiPayload.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseResponse;
import umc.spring.apiPayload.code.ResponseDto;

@Getter
@AllArgsConstructor
public enum SuccessResponse implements BaseResponse {
    // 일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ResponseDto buildDto() {
        return ResponseDto.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ResponseDto buildDtoWithHttpStatus() {
        return ResponseDto.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
