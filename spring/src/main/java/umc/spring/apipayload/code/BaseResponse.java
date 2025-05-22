package umc.spring.apipayload.code;

public interface BaseResponse {
    Response buildDto();
    Response buildDtoWithHttpStatus();
}
