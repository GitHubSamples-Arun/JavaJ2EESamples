package com.springboot.jersey.springbootjerseyhelloworld.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.springboot.jersey.springbootjerseyhelloworld.model.User;
 
@Service
public class UserService {
  private Map<String,User> users;
 
  @PostConstruct
  private void loadUser() {
    users = new HashMap<>();
    users.put("1",new User("Tom",20));
    users.put("2",new User("Jerry",19));
  }
 
  public User findById(String id) {
    return users.get(id);
  }
}