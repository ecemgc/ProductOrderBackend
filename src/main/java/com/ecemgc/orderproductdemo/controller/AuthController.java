package com.ecemgc.orderproductdemo.controller;

import com.ecemgc.orderproductdemo.request.LoginRequest;
import com.ecemgc.orderproductdemo.request.RegisterRequest;
import com.ecemgc.orderproductdemo.response.AuthResponse;
import com.ecemgc.orderproductdemo.service.auth.intf.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse authenticate(@RequestBody LoginRequest loginRequest) {
        return authService.authenticate(loginRequest);
    }
}
