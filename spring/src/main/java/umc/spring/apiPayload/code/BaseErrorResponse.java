package umc.spring.apiPayload.code;

public interface BaseErrorResponse {
    ErrorResponseDto buildErrorDto();
    ErrorResponseDto buildErrorDtoWithHttpStatus();
}
