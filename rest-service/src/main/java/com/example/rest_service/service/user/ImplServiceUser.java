package com.example.rest_service.service.user;
import com.example.rest_service.models.User;
import com.example.rest_service.repository.UserRepository;
import com.example.rest_service.service.JWTService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class ImplServiceUser implements IUserService {
    private static final Logger log = LoggerFactory.getLogger(ImplServiceUser.class);
    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepository repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public User saveUser(User user) {
        return repo.save(user);
    }
    //findall c'est select*
    @Override
    public List<User> findAllUsers() {
        return this.repo.findAll();
    }


    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public String verify(User user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            log.info("User {} logged in successfully", user.getUsername());
            return jwtService.generateToken(user.getUsername());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
