package com.ecemgc.orderproductdemo.service.user.impl;

import com.ecemgc.orderproductdemo.entity.UserEntity;
import com.ecemgc.orderproductdemo.exception.NotFoundException;
import com.ecemgc.orderproductdemo.repository.UserRepository;
import com.ecemgc.orderproductdemo.service.user.intf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserEntity findByEmail(String email) throws NotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found with by email: " + email));
    }
}
