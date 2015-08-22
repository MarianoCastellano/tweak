package com.gm.tweak.application.controller;

import com.gm.tweak.application.controller.request.UserRegisterRequest;
import com.gm.tweak.application.service.UserRegisterService;
import com.gm.tweak.domain.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserRegisterController {

    @Resource(name = "userRegisterService")
    private UserRegisterService userRegisterService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        String email = userRegisterRequest.getEmail();
        String username = userRegisterRequest.getUsername();
        String password = userRegisterRequest.getPassword();
        return new ResponseEntity<User>(userRegisterService.register(email, username, password), HttpStatus.CREATED);
    }
}
