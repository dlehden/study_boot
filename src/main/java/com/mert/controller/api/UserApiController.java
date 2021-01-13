package com.mert.controller.api;

import com.mert.dto.GridUpdateDto;
import com.mert.model.User;
import com.mert.model.userListHeader.Header;
import com.mert.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserApiController {

    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService){
        this.userService = userService;
    }


    //data create
    /*@PostMapping("/list")
    public Header createPeople(@RequestBody GridUpdateDto req){
        log.info("post request : {}", req);
        System.out.println("str : " + req);
        return userService.updateUserList(req);
    }*/

    @GetMapping("/list")
    public Header getPeopleList(){
        return userService.getAllUserList();
    }

    //data modify
    @PutMapping("/list")
    public Header modifyPeople(@RequestBody GridUpdateDto req){
        log.info("put request : {}", req);
        System.out.println("str : " + req);
        return userService.updateUserList(req);
    }

    //data delete
    /*@DeleteMapping("/list")
    public Header deletePeople(@RequestBody GridUpdateDto req){
        log.info("delete request : {}", req);
        System.out.println("str : " + req);
        return userService.updateUserList(req);
    }*/

    @GetMapping("/search")
    public List<User> searchByName(User user){
        System.out.println("name : " + user.getName());
        return userService.findByName(user.getName());
    }
}
