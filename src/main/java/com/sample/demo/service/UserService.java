package com.sample.demo.service;
import java.util.*;

import com.sample.demo.entity.JwtResponse;
import com.sample.demo.entity.UserEntity;
import com.sample.demo.entity.UserLogin;
import com.sample.demo.entity.getUserDetails;
import com.sample.demo.util.JWTUtility;
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
public class UserService implements UserDetailsService {

    @Autowired
     JWTUtility jwtUtility;
    @Autowired
     UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

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

        //Logic to get the user form the Database

        return new User("admin","password",new ArrayList<>());
    }
    public JwtResponse login1(UserLogin jwtRequest) {
//        User user=userDetails.get()

            if (userDetails.containsKey(jwtRequest.getEmail())) {
                System.out.println("Login sucessfully");
                try {
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    jwtRequest.getEmail(),
                                    jwtRequest.getPassword()
                            )
                    );
                } catch (BadCredentialsException e) {
//                    throw new Exception("INVALID_CREDENTIALS", e);
                }

                final UserDetails userDetails
                        = userService.loadUserByUsername(jwtRequest.getEmail());

                final String token =
                        jwtUtility.generateToken(userDetails);

                return  new JwtResponse(token);

//                String password = user.getPassword();
//                String encryptedpassword = null;
//                MessageDigest m = MessageDigest.getInstance("MD5");
//
//                m.update(password.getBytes());
//
//                byte[] bytes = m.digest();
//
//                StringBuilder s = new StringBuilder();
//                for (int i = 0; i < bytes.length; i++) {
//                    s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//                }
//
//                encryptedpassword = s.toString();
//                System.out.println("UserName: " + user.getEmail());
//                System.out.println("Plain-text password: " + password);
//                System.out.println("Encrypted password using MD5: " + encryptedpassword);
//
            }
         else{
            System.out.println("Email or password wrong");
                return  new JwtResponse("Invalid credentials");
        }
    }




    public UserEntity getUser(getUserDetails user) {
        try {
            UserEntity userEntity3 =userDetails.get(user);
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
//                  .filter(c->c.getUserId().startsWith(str))
//                  .filter(c->c.getUserEmail().startsWith(str))
                  .collect(Collectors.toList());


    }
}




