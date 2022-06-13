package com.sample.demo.testController;
import static org.junit.Assert.*;
import com.sample.demo.entity.User;
import com.sample.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class TestServices {
@Autowired
    UserService userService;
    @Test
    public void testRegister() {
        Map<String, User> userDetails = new HashMap<>();
        User user1= new User();
        user1.setUserId("101");
        user1.setUserName("sarankumar");
        user1.setUserEmail("sarankumar@gmail.com");
        user1.setPassword("Saran25*");

        userDetails.put(user1.getUserEmail(), user1);

//        userService.register(user1);

//        assertEquals(userDetails.containsKey(user1.getUserEmail()),"sarankumar@gmail.com");
        assertEquals(user1.getUserId(),"101");
        assertEquals(user1.getPassword(),"Saran25*");
        assertNotEquals(user1.getUserName(),"saran");
    }
}
