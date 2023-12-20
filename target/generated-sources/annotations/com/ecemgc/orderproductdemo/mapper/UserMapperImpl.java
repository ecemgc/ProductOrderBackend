package com.ecemgc.orderproductdemo.mapper;

import com.ecemgc.orderproductdemo.entity.UserEntity;
import com.ecemgc.orderproductdemo.request.RegisterRequest;
import com.ecemgc.orderproductdemo.response.AuthUserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-18T00:45:27+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName( request.getFirstName() );
        userEntity.setLastName( request.getLastName() );
        userEntity.setEmail( request.getEmail() );
        userEntity.setPassword( request.getPassword() );

        return userEntity;
    }

    @Override
    public AuthUserResponse toAuthUser(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AuthUserResponse.AuthUserResponseBuilder authUserResponse = AuthUserResponse.builder();

        authUserResponse.email( entity.getEmail() );
        authUserResponse.firstName( entity.getFirstName() );
        authUserResponse.lastName( entity.getLastName() );

        return authUserResponse.build();
    }
}
