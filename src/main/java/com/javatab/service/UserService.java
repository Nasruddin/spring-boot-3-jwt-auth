package com.javatab.service;

import com.javatab.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    Optional<User> getUserByUsername(String username);
}
