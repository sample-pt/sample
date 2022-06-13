package com.sample.demo.controller;
import com.sample.demo.entity.User;
import com.sample.demo.entity.UserLogin;
import com.sample.demo.entity.getUserDetails;
import com.sample.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userservice;

    @PostMapping(value = "/register",consumes = {MediaType.ALL_VALUE})
    public ResponseEntity<String> saveUser( @RequestBody @Valid User user) {
        Map<String, User> userDetails = userservice.register(user);
        System.out.println(userDetails);

//        return "User Registration was successful.";
        return ResponseEntity.status(201).body("User Registration was successful.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(  @RequestBody @Valid UserLogin userLogin) {

        String Response=userservice.login1(userLogin);
        return ResponseEntity.status(200).body(Response);
    }

    @PostMapping("/getUser")
    public ResponseEntity<User> getUser( @RequestBody @Valid getUserDetails user) {

        User userDetails = userservice.getUser(user);
        System.out.println(userDetails);
        return ResponseEntity.status(200).body(userDetails);
    }

//    @GetMapping("/filter/{filter}")
//    public Void filter(@RequestParam("str") String str){
//
//        userservice.search(str);
//
//    }


}
