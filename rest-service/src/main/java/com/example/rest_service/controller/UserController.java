package com.example.rest_service.controller;
import com.example.rest_service.generic.ControllerGeneric;
import com.example.rest_service.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Ce controlleur n'est pas obligatoire je l'ai implémenter pour insérer des utilisateurs dans ma base afin de la tester
@RestController
@RequestMapping("/users")
public class UserController extends ControllerGeneric<User,Long> {

}
