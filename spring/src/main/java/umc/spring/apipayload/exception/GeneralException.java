package umc.spring.apipayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.apipayload.code.BaseErrorResponse;
import umc.spring.apipayload.code.ErrorResponse;

// 사용자 정의 exception
@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorResponse code;

    public ErrorResponse getErrorResponseDto() {
        return this.code.buildErrorDto();
    }
    public ErrorResponse getErrorResponseDtoWithHttpStatus() {
        return this.code.buildErrorDtoWithHttpStatus();
    }
}
