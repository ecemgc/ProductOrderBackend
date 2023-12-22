package com.ecemgc.orderproductdemo.controller;

import com.ecemgc.orderproductdemo.request.RequestLogin;
import com.ecemgc.orderproductdemo.request.RequestRegister;
import com.ecemgc.orderproductdemo.response.ResponseAuth;
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

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseAuth login(@RequestBody RequestLogin requestLogin){
        return authService.login(requestLogin);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAuth register(@RequestBody RequestRegister requestRegister){
        return authService.register(requestRegister);
    }


}
