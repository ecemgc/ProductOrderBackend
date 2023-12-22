package com.ecemgc.orderproductdemo.service.user.impl;

import com.ecemgc.orderproductdemo.entity.UserEntity;
import com.ecemgc.orderproductdemo.repository.UserRepository;
import com.ecemgc.orderproductdemo.service.user.intf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }


    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }
}
