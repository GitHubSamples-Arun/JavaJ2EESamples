package com.springboot.rest.deptcrudjersey.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.deptcrudjersey.model.User;

@Repository
public interface UserCRUDRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
