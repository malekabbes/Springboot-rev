package com.example.rest_service.controller;
import com.example.rest_service.generic.ControllerGeneric;
import com.example.rest_service.models.User;
import com.example.rest_service.service.user.ImplServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Ce controlleur n'est pas obligatoire je l'ai implémenter pour insérer des utilisateurs dans ma base afin de la tester
@RestController
@RequestMapping("/users")
public class UserController extends ControllerGeneric<User,Long> {

    @Autowired
    private ImplServiceUser Userservice;


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return Userservice.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        return Userservice.verify(user);
    }
}
