package umc.spring.apiPayload.exception.handler;


import lombok.Getter;
import umc.spring.apiPayload.status.ErrorResponse;

@Getter
public class UserHandler extends RuntimeException {

    private final ErrorResponse errorResponse;

    public UserHandler(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }
}
