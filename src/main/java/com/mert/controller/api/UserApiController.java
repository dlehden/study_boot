package com.mert.controller.api;

import com.mert.model.userLIstHeader.Header;
import com.mert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserApiController {

    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get-list")
    public Header getPeopleList(){
        return userService.getUserList();
    }
}
