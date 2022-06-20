package com.sample.demo.testController;
import com.sample.demo.entity.UserEntity;
import com.sample.demo.entity.getUserDetails;
import com.sample.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestServices {

       @Autowired
        UserService userService;

    Util util=new Util();
    @Test
    public void TestRegisterMethod() {

        Map<String, UserEntity> userDetails = new HashMap<>();
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUserEmail("saran@gmail.com");
        userEntity1.setPassword("123456");
        userEntity1.setUserId("101");
        userEntity1.setUserName("saran");

        userDetails.put(userEntity1.getUserEmail(), userEntity1);

        assertEquals(userDetails.containsKey(userEntity1.getUserEmail()), true);

        assertEquals(userEntity1, userDetails.get("saran@gmail.com"));

        assertEquals(userDetails.get(userEntity1.getUserEmail()), userEntity1);
    }


    @Test
    public void TestLoginMethod() {
        final String userEmail = "saran@gmail.com";
        final String password = "123456";
        assertEquals(util.utilMethod(),userEmail);

    }
//    @Test
//    public void TestFilterMethod(){
//
//        String str="s";
//        List<UserEntity> users= userService.search(str);
//         System.out.println(users);
//    }
}