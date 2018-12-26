package com.springbootangular.userportal.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.springbootangular.userportal.entity.User;

public interface UserRepository extends Repository<User, Integer> {

    void delete(User user);

    List<User> findAll();

    User findOne(int id);

    User save(User user);
}
