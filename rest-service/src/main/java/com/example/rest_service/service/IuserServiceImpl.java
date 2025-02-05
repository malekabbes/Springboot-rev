package com.example.rest_service.service;

import com.example.rest_service.models.User;
import com.example.rest_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class IuserServiceImpl implements IuserService{
    //repository fait l'interaction avec la base c'est pour cette raison qu'on l'utilisera pour effectuer les operation crud
    @Autowired
    private UserRepository userRep;

    @Override
    //save pour insert
    public User saveUser(User user) {
        return userRep.save(user);
    }
    //findall c'est select*
    @Override
    public List<User> findAllUsers() {
        return this.userRep.findAll();
    }
}
