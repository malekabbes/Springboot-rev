package com.example.rest_service.service.user;
import com.example.rest_service.generic.ImplementationGeneric;
import com.example.rest_service.models.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ImplServiceUser  extends ImplementationGeneric<User, Long> implements IUserService {

}
