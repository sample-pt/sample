package com.sample.demo.controller;
import com.sample.demo.entity.*;
import com.sample.demo.service.UserService;
import com.sample.demo.util.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userservice;



    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody UserLogin jwtRequest) throws Exception{
        userservice.login1(jwtRequest);
        return  userservice.login1(jwtRequest);
    }






    @PostMapping(value = "/register",consumes = {MediaType.ALL_VALUE})
    public ResponseEntity<String> saveUser( @RequestBody @Valid UserEntity userEntity) {
        Map<String, UserEntity> userMap = userservice.register(userEntity);
        System.out.println(userMap);

//        return "User Registration was successful.";
        return ResponseEntity.status(201).body("User Registration was successful.");
    }

    @PostMapping("/login")
    public ResponseEntity< JwtResponse> login(  @RequestBody @Valid UserLogin userLogin) {

        JwtResponse Response=userservice.login1(userLogin);
        return ResponseEntity.status(200).body(Response);
    }

    @PostMapping("/getUser")
    public ResponseEntity<UserEntity> getUser(@RequestBody @Valid getUserDetails user) {

        UserEntity Details = userservice.getUser(user);
        System.out.println(Details);
        return ResponseEntity.status(200).body(Details);
    }

    @GetMapping("/getAllUsers")
    public Collection<UserEntity> filter(){

         return userservice.getAllUsers();
    }

    @GetMapping("/getUserWithFilter/{str}")
    public List<UserEntity> search(@PathVariable("str") @NotNull String str) {

        return userservice.search(str);
    }
}
