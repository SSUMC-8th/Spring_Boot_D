package umc.spring.apipayload.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apipayload.code.BaseResponse;
import umc.spring.apipayload.code.Response;

@Getter
@AllArgsConstructor
public enum SuccessResponse implements BaseResponse {
    // 일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public Response buildDto() {
        return Response.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public Response buildDtoWithHttpStatus() {
        return Response.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
