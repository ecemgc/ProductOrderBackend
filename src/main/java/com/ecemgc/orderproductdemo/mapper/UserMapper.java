package com.ecemgc.orderproductdemo.mapper;

import com.ecemgc.orderproductdemo.entity.UserEntity;
import com.ecemgc.orderproductdemo.request.RegisterRequest;
import com.ecemgc.orderproductdemo.response.AuthUserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(RegisterRequest request);
    AuthUserResponse toAuthUser(UserEntity entity);
}
