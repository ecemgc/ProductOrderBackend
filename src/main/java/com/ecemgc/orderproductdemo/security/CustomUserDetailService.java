package com.ecemgc.orderproductdemo.security;

import com.ecemgc.orderproductdemo.entity.UserEntity;
import com.ecemgc.orderproductdemo.service.user.intf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with: " + username);
        }

        return user;

    }
}
