package com.demo.repository;

import com.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User getUserById(int id);
    List<User> getUsersByAgeGreaterThan(int age);
    List<User> findAll();


}
