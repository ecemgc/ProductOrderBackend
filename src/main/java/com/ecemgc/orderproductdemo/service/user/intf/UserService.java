package com.ecemgc.orderproductdemo.service.user.intf;


import com.ecemgc.orderproductdemo.entity.UserEntity;
import com.ecemgc.orderproductdemo.exception.NotFoundException;


public interface UserService {

    UserEntity findByEmail(String email) throws NotFoundException;

}
