package com.colitsys.feeplaza.controller;

import com.colitsys.feeplaza.model.User;
import com.colitsys.feeplaza.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create user accounts.
 */
@RestController
public class UserRegistrationController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public User registerUser(@RequestBody final User user) {
        return repository.save(user);
    }
}
