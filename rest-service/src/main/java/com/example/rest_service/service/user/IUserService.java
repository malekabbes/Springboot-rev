package com.example.rest_service.service.user;

import com.example.rest_service.models.User;

import java.util.List;

public interface IUserService  {

    //save pour insert
    User saveUser(User user);

    //findall c'est select*
    List<User> findAllUsers();
}
