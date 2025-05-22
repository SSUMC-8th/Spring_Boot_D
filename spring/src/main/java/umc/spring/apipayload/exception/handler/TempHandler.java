package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorResponse;
import umc.spring.apipayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorResponse errorResponse) {
        // 부모인 GeneralException 생성자 호출
        super(errorResponse);
    }
}