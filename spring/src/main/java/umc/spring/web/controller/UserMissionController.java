package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.UserMissionConverter;
import umc.spring.service.usermission.UserMissionService;
import umc.spring.web.dto.usermission.UserMissionRequest;
import umc.spring.web.dto.usermission.UserMissionResponse;

@RestController
@RequestMapping("/api/v1/user-mission")
@RequiredArgsConstructor
public class UserMissionController {
    private final UserMissionService service;
    private final UserMissionConverter converter;

    @PostMapping
    public ResponseEntity<ApiResponse<UserMissionResponse>> apply(
            @Valid @RequestBody UserMissionRequest req
    ) {
        var entity = service.apply(req);
        var dto    = converter.toResponse(entity);
        return ResponseEntity
                .status(201)
                .body(ApiResponse.onSuccess(dto));
    }
}

