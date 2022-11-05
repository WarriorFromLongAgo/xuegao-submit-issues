package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
public class UserInfoTest extends GenericModel<Integer> {

    private String username;

    private String password;

    public UserInfoTest() {
    }
}
