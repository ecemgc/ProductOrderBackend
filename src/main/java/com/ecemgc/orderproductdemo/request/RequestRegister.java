package com.ecemgc.orderproductdemo.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestRegister {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
