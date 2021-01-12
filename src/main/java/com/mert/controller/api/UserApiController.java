package com.mert.controller.api;

import com.mert.model.User;
import com.mert.model.userLIstHeader.Header;
import com.mert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get-list")
    public Header getPeopleList(){
        return userService.getAllUserList();
    }

    @GetMapping("/search")
    public List<User> searchByName(User user){
        System.out.println("name : " + user.getName());
        return userService.findByName(user.getName());
        //return userService.getUserListByName(user.getName());
    }
}
