package com.javatab.service;

import com.javatab.domain.entity.User;

import java.util.List;

/**
 * Created by nasir on 6/2/16.
 */
public interface UserService {

    List<User> getAllUsers();
    User getUserByUsername(String username);
}
