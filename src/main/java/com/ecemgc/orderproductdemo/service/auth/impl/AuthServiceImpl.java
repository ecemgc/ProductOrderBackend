package com.ecemgc.orderproductdemo.service.auth.impl;

import com.ecemgc.orderproductdemo.entity.UserEntity;
import com.ecemgc.orderproductdemo.mapper.UserMapper;
import com.ecemgc.orderproductdemo.request.RequestLogin;
import com.ecemgc.orderproductdemo.request.RequestRegister;
import com.ecemgc.orderproductdemo.response.ResponseAuth;
import com.ecemgc.orderproductdemo.response.ResponseUser;
import com.ecemgc.orderproductdemo.security.JwtUtils;
import com.ecemgc.orderproductdemo.service.auth.intf.AuthService;
import com.ecemgc.orderproductdemo.service.user.intf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public ResponseAuth login(RequestLogin requestLogin) {
        var a = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestLogin.getEmail(), requestLogin.getPassword()));
        UserEntity user = userService.findByEmail(requestLogin.getEmail());
        return createResponseAuth(user);
    }

    @Override
    public ResponseAuth register(RequestRegister requestRegister) {
        requestRegister.setPassword(passwordEncoder.encode(requestRegister.getPassword()));
        var user = userService.save(userMapper.toEntity(requestRegister));
        return createResponseAuth(user);
    }

    private ResponseAuth createResponseAuth(UserEntity user) {
      return ResponseAuth
                .builder()
                        .token(jwtUtils.generateToken(user.getEmail(), user.getAuthorities()))
                                .user(ResponseUser
                                        .builder()
                                        .firstName(user.getFirstName())
                                        .lastName(user.getLastName())
                                        .email(user.getEmail())
                                        .build())
                .build();
    }
}
