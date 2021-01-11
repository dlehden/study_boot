package com.mert.service;

import com.mert.model.userLIstHeader.Header;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUserList(){
        Header resultList = userService.getUserList();
        System.out.println(resultList);
    }
}