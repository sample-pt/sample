package com.sample.demo.testController;

import com.sample.demo.entity.UserEntity;

import java.util.HashMap;
import java.util.Map;

public class Util {

    public String utilMethod() {
        Map<String, UserEntity> userDetails = new HashMap<>();
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUserEmail("saran@gmail.com");
        userEntity1.setPassword("123456");
        userEntity1.setUserId("101");
        userEntity1.setUserName("saran");

        userDetails.put(userEntity1.getUserEmail(), userEntity1);
        return userEntity1.getUserEmail();

    }

}
