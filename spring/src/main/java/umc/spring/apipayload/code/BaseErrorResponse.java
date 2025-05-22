package umc.spring.apipayload.code;

public interface BaseErrorResponse {
    ErrorResponse buildErrorDto();
    ErrorResponse buildErrorDtoWithHttpStatus();
}
