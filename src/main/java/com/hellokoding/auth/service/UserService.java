package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Ospatar;
import com.hellokoding.auth.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User findById(Long id);

    User findByEmail(String email);
    void update(User user);
    List<User> findAll();
}
