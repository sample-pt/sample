package com.sample.demo.service;
import java.util.*;
import com.sample.demo.entity.User;
import com.sample.demo.entity.UserLogin;
import com.sample.demo.entity.getUserDetails;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Predicate;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {
    Map<String, User> userDetails = new HashMap<>();
    Collection<User> val = userDetails.values();
    public Map<String, User> register(User user) {

        User user1 = new User();
        user1.setUserId(user.getUserId());
        user1.setUserName(user.getUserName());
        user1.setUserEmail(user.getUserEmail());
        user1.setPassword(user.getPassword());
        try {
            userDetails.put(user1.getUserEmail(), user1);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        return userDetails;
    }

    public String login1(UserLogin user) {
//        User user=userDetails.get()

            if (userDetails.containsKey(user.getEmail())) {
                System.out.println("Login sucessfully");
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
                return "Login successfully";
            }
         else{
            System.out.println("Email or password wrong");
            return "User not Exist,login failure";
        }
    }




    public User getUser(getUserDetails user) {
        try {
            User user3=userDetails.get(user);
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


    public Collection<User> getAllUsers(){

        return val;

    }
    public List<User> search( String str){


          return  val.stream()
                  .filter(c->c.getUserName().startsWith(str))
//                  .filter(c->c.getUserId().startsWith(str))
//                  .filter(c->c.getUserEmail().startsWith(str))
                  .collect(Collectors.toList());


    }
}




