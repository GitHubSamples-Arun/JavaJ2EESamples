package com.springboot.rest.deptcrudjersey.service;

import java.util.List;

import com.springboot.rest.deptcrudjersey.model.User;
import com.springboot.rest.deptcrudjersey.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
}
