package com.ecemgc.orderproductdemo.service.auth.intf;

import com.ecemgc.orderproductdemo.request.LoginRequest;
import com.ecemgc.orderproductdemo.request.RegisterRequest;
import com.ecemgc.orderproductdemo.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(LoginRequest request);
}
