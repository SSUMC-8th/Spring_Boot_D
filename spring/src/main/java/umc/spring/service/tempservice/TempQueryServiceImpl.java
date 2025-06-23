package umc.spring.service.tempservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//import umc.spring.apiPayload.status.ErrorResponse;
//import umc.spring.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{
    @Override
    public void CheckFlag(Integer flag) {
        // if (flag == 1)
           // throw new TempHandler(ErrorResponse.TEMP_EXCEPTION);
    }
}
