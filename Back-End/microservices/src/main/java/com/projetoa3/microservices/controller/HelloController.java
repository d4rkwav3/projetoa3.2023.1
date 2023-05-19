package com.projetoa3.microservices.controller;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.projetoa3.microservices.repository.LoginRepository;

import com.projetoa3.microservices.model.Login;

@RestController
@RequestMapping("/")
public class HelloController {

    private final LoginRepository loginRepository;

    public HelloController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @GetMapping
    public Optional<Login> findUser(
        @RequestParam(name = "user") String user
        ) {
            Login loginAttempt = new Login();
            loginAttempt.setEmail(user);
            Example<Login> example = Example.of(loginAttempt);
            return loginRepository.findOne(example);
    }

}
