package com.example.accdls.controller;

import com.example.accdls.dto.request.ApiResponse;
import com.example.accdls.dto.request.AuthenticationRequest;
import com.example.accdls.dto.request.IntrospectRequest;
import com.example.accdls.dto.response.AuthenticationResponse;
import com.example.accdls.dto.response.IntrospectResponse;
import com.example.accdls.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var results = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .results(results)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        IntrospectResponse results = authenticationService.instrospect(request);

        return ApiResponse.<IntrospectResponse>builder()
                .results(results)
                .build();
    }
}
