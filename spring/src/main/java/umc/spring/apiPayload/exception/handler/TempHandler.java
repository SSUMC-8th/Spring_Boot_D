package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorResponse;
import umc.spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorResponse errorResponse) {
        // 부모인 GeneralException 생성자 호출
        super(errorResponse);
    }
}