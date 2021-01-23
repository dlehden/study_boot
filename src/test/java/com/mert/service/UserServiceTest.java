package com.mert.service;

import com.mert.dto.gridDto.GridUpdateDto;
import com.mert.dto.userDto.UserDto;
import com.mert.model.userModel.userListHeader.Header;
import com.mert.repository.userInfoRepository.UserRepository;
import com.mert.service.userService.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

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

    @Test
    @Transactional
    public void update(){
        UserDto user1 = UserDto.builder().id(1L).email("test1@test.com").name("test1").build();
        UserDto user2 = UserDto.builder().id(2L).email("test2@test.com").name("test2").build();
        ArrayList<UserDto> list = new ArrayList<UserDto>();
        list.add(user1);
        list.add(user2);
        GridUpdateDto update = GridUpdateDto.builder()
                .updatedRows(list)
                .build();
        userService.updateUserList(update);

        Assertions.assertAll(
                ()->Assertions.assertEquals(user1.getName(),
                        userRepository.findById(1L).get().getName()),

                ()->Assertions.assertEquals(user2.getName(),
                        userRepository.findById(2L).get().getName())
        );
    }
}