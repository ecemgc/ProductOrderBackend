package com.ecemgc.orderproductdemo.service.auth.impl;

import com.ecemgc.orderproductdemo.entity.UserEntity;
import com.ecemgc.orderproductdemo.mapper.UserMapper;
import com.ecemgc.orderproductdemo.repository.UserRepository;
import com.ecemgc.orderproductdemo.request.LoginRequest;
import com.ecemgc.orderproductdemo.request.RegisterRequest;
import com.ecemgc.orderproductdemo.response.AuthResponse;
import com.ecemgc.orderproductdemo.security.JwtUtils;
import com.ecemgc.orderproductdemo.service.auth.intf.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponse register(RegisterRequest request) {
        UserEntity user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return createAuthResponse(user);
    }

    @Override
    public AuthResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        UserEntity user = userRepository.findByEmail(request.getEmail()).orElse(null);
        if(user == null) {
            return null;
        }
        return createAuthResponse(user);
    }

    private AuthResponse createAuthResponse(UserEntity user) {
        return AuthResponse
                .builder()
                .token(jwtUtils.generateToken(user.getEmail(), Collections.singletonList("USER")))
                .user(userMapper.toAuthUser(user))
                .build();
    }
}
