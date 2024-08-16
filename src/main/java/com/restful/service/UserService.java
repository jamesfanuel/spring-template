package com.restful.service;

import com.restful.entity.User;
import com.restful.model.RegisterUserRequest;
import com.restful.model.UpdateUserRequest;
import com.restful.model.UserResponse;
import com.restful.security.BCrypt;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.restful.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private Validator validator;

    @Transactional
    public void register(RegisterUserRequest request){
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() != 0) {
            throw new ConstraintViolationException(constraintViolations);
        }

        if(userRepository.findFirstByMemberUsername(request.getMemberUsername()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setMemberUsername(request.getMemberUsername());
        user.setMemberPassword(BCrypt.hashpw(request.getMemberPassword(), BCrypt.gensalt()));
        user.setMemberFullname(request.getMemberFullname());
        user.setMemberLevel(request.getMemberLevel());
        user.setMemberActiveStatus(1);
        user.setMemberEmail(request.getMemberEmail());

        userRepository.save(user);
    }

    public UserResponse get(User user) {
        return UserResponse.builder()
                .memberUsername(user.getMemberUsername())
                .memberFullname(user.getMemberFullname())
                .memberEmail(user.getMemberEmail())
                .memberLevel(user.getMemberLevel())
                .build();
    }

    @Transactional
    public UserResponse update(User user, UpdateUserRequest request) {
        Set<ConstraintViolation<UpdateUserRequest>> constraintViolations = validator.validate(request);

        log.info("REQUEST : {}", request);

        if (Objects.nonNull(request.getMemberUsername())) {
            user.setMemberUsername(request.getMemberUsername());
        }

        if (Objects.nonNull(request.getMemberPassword())) {
            user.setMemberPassword(BCrypt.hashpw(request.getMemberPassword(), BCrypt.gensalt()));
        }

        userRepository.save(user);

        log.info("USER : {}", user.getMemberUsername());

        return UserResponse.builder()
                .memberUsername(user.getMemberUsername())
                .memberFullname(user.getMemberFullname())
                .build();
    }
}
