package com.ecemgc.orderproductdemo.service.user.intf;


import com.ecemgc.orderproductdemo.entity.UserEntity;


public interface UserService {

    UserEntity findByEmail(String email);

}
