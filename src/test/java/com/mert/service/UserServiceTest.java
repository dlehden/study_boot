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
    public void getAllUserList(){
        Header resultList = userService.getAllUserList();
        System.out.println(resultList);
    }

    @Test
    public void getUserListByName(){
        String name = "홍성현";
        Header resultList = userService.getUserListByName(name);
        System.out.println(resultList);
    }
}