package com.example.rest_service.controller;

import com.example.rest_service.service.IuserService;

import com.example.rest_service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Ce controlleur n'est pas obligatoire je l'ai implémenter pour insérer des utilisateurs dans ma base afin de la tester
@RestController
@RequestMapping("/users")
public class UserController {

    //le controleur va utiliser les methodes de l'interface userService
    private final IuserService userService;

    @Autowired
    public UserController(IuserService userService) {
        this.userService = userService;
    }

    //Ici l'ajout d'un utilisteur par la methode post on utilise saveuser implémenté dans userService
    @PostMapping("/adduser")
    public User createUser( @RequestBody User user) {
        return userService.saveUser(user);
    }

}
