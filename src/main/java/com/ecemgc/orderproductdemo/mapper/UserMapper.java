package com.ecemgc.orderproductdemo.mapper;

import com.ecemgc.orderproductdemo.entity.UserEntity;
import com.ecemgc.orderproductdemo.request.RequestRegister;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(RequestRegister requestRegister);
}
