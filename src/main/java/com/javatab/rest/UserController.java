package com.javatab.rest;

import com.javatab.domain.entity.User;
import com.javatab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nasir on 6/2/16.
 */
@RestController
@RequestMapping("${javatab.route.user}")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> userList = userService.getAllUsers();

        return ResponseEntity.ok(userList);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByName(@PathVariable("username") String username) {

        User aUser = userService.getUserByUsername(username);

        return ResponseEntity.ok(aUser);
    }
}
