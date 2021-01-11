package com.mert.service;

import java.util.*;
import java.util.stream.Collectors;

import com.mert.dto.UserDto;
import com.mert.model.userLIstHeader.Dat;
import com.mert.model.userLIstHeader.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mert.model.Role;
import com.mert.model.User;
import com.mert.repository.RoleRepository;
import com.mert.repository.UserRepository;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        return users;
    }

    public User findUser(int id) {
        return userRepository.findById(id).get();
    }

    public void delete(int id) {
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

    public Header getUserList(){
        List<User> userList = userRepository.findAll();
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
}
