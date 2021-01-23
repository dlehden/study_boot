package com.mert.controller.userController.api;

import com.mert.dto.gridDto.GridUpdateDto;
import com.mert.model.userModel.User;
import com.mert.model.userModel.userListHeader.Header;
import com.mert.service.userService.UserService;
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

    @GetMapping("/test/{id}/test2/{id2}")
    public void testPeople(@PathVariable Long id, @PathVariable Long id2){
        
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
