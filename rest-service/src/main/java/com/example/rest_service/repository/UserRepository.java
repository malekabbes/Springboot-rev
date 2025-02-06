package com.example.rest_service.repository;


import com.example.rest_service.generic.GenericRepo;
import com.example.rest_service.models.User;
import java.util.Optional;

public interface UserRepository extends GenericRepo<User, Long> {
    User findByUsername(String username);
}