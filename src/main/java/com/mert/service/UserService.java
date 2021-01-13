package com.mert.service;

import java.util.*;
import java.util.stream.Collectors;

import com.mert.dto.GridUpdateDto;
import com.mert.dto.UserDto;
import com.mert.model.userListHeader.Dat;
import com.mert.model.userListHeader.Header;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mert.model.Role;
import com.mert.model.User;
import com.mert.repository.RoleRepository;
import com.mert.repository.UserRepository;

@Service("userService")
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public List<User> findByName(String name){
        List<User> users = userRepository.findByName(name);
        return users;
    }
    public User findUser(Long id) {
        return userRepository.findById(id).get();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    public void save(User user) {
        userRepository.save(user);
    }


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void saveUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRole(userRole);
        userRepository.save(user);
    }

    public List<User> findUserbyRole(Role role) {
        return userRepository.findByRole(role);
    }

    public Header getAllUserList(){
        List<User> userList = userRepository.findAll();
        return getUserList(userList);
    }

    public Header getUserListByName(String name){
        List<User> userList = userRepository.findByName(name);
        return getUserList(userList);
    }

    public Header getUserList(List<User> userList){
        log.info("search!");
        List<UserDto> nameAndEmailList=
                userList.stream()
                        .map(user -> {
                            return UserDto.builder()
                                    .name(user.getName())
                                    .email(user.getEmail())
                                    .build();
                        }).collect(Collectors.toList());

        Header header = Header.builder()
                .result(true)
                .data(Dat.builder().contents(nameAndEmailList).build())
                .build();
        return header;
    }

    public Header updateUserList(GridUpdateDto req){
        boolean result = true;
        String message = null;
        req.getUpdatedRows().forEach(userDto->{
            Optional<User> opt = userRepository.findById(userDto.getId());
            opt.ifPresent(user->{
                user.setName(userDto.getName());
                user.setEmail(userDto.getEmail());
                User newUser = userRepository.save(user);

                // 수정 제대로 됐는지 검증 절차 필요
                /*if(newUser.getName() != userDto.getName() || newUser.getEmail()!=userDto.getEmail()) {

                }*/
            });
        });
        return Header.builder()
                .result(result)
                .message(message)
                .build();
    }
}
