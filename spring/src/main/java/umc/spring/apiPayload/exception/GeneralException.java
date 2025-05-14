package umc.spring.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.apiPayload.code.BaseErrorResponse;
import umc.spring.apiPayload.code.ErrorResponseDto;

// 사용자 정의 exception
@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorResponse code;

    public ErrorResponseDto getErrorResponseDto() {
        return this.code.buildErrorDto();
    }
    public ErrorResponseDto getErrorResponseDtoWithHttpStatus() {
        return this.code.buildErrorDtoWithHttpStatus();
    }
}
