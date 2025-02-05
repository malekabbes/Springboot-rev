package com.example.rest_service.service;

import java.util.List;
import com.example.rest_service.models.User;

public interface IuserService {

    //ici signature de methode de création de mes utilisateurs
    //c'est pas demander mais j'ai choisi de remplir mes utilisateurs d'après un API comme ca je peux comprendre mieux avant de passer à faire le travail demandé avec book

    //save user équivalent à insert
    User saveUser(User user);

    //find all c'est select * dans sql
    List<User> findAllUsers();


}
