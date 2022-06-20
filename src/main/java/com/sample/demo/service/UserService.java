package com.sample.demo.service;
import java.util.*;

import com.sample.demo.entity.*;
import com.sample.demo.util.JWTUtility;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService{

    @Autowired
     JWTUtility jwtUtility;
    @Autowired
     UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    Map<String, UserEntity> userDetails = new HashMap<>();
    Collection<UserEntity> val = userDetails.values();
    public Map<String, UserEntity> register(UserEntity userEntity) {

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUserId(userEntity.getUserId());
        userEntity1.setUserName(userEntity.getUserName());
        userEntity1.setUserEmail(userEntity.getUserEmail());
        userEntity1.setPassword(userEntity.getPassword());
        try {
            userDetails.put(userEntity1.getUserEmail(), userEntity1);

        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        return userDetails;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

           return new org.springframework.security.core.userdetails.User("saran25@gmail.com", "Saran25@", new ArrayList<>());
    }

    public String login1(JwtRequest jwtRequest) throws Exception {
            try {
                if (userDetails.containsKey(jwtRequest.getUsername())) {
                    System.out.println("User is Exist");
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
                    );
                }
            }catch (Exception ex) {
                throw new Exception("invalid username/password");
            }
            return jwtUtility.generateToken(jwtRequest.getUsername());
    }


    public UserEntity getUser(getUserDetails user) {
        try {
//            UserEntity userEntity3 =userDetails.get(user);
            if (userDetails.containsKey(user.getUserEmail())) {
                System.out.println("The UserId is Exist");

            } else {
                System.out.println("The UserId is not Exist");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

        return userDetails.get(user.getUserEmail());

    }


    public Collection<UserEntity> getAllUsers(){

        return val;

    }
    public List<UserEntity> search(String str){


          return  val.stream()
                  .filter(c->c.getUserName().startsWith(str))
                  .collect(Collectors.toList());


    }
}




