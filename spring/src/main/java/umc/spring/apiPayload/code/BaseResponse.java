package umc.spring.apiPayload.code;

public interface BaseResponse {
    ResponseDto buildDto();
    ResponseDto buildDtoWithHttpStatus();
}
