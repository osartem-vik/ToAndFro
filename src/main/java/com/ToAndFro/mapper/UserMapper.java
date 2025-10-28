package com.ToAndFro.mapper;

import com.ToAndFro.models.User;

public class UserMapper {
    public User createUser(Long id, String email, String password, String lastName, String firstName, String phone){
        return new User(id, email, password, lastName, firstName, phone);
    }
}
