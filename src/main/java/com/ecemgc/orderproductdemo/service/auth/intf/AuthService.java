package com.ecemgc.orderproductdemo.service.auth.intf;

import com.ecemgc.orderproductdemo.request.RequestLogin;
import com.ecemgc.orderproductdemo.request.RequestRegister;
import com.ecemgc.orderproductdemo.response.ResponseAuth;

public interface AuthService {
    ResponseAuth login(RequestLogin requestLogin);
    ResponseAuth register(RequestRegister requestRegister);
}
