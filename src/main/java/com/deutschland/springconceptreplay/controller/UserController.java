package com.deutschland.springconceptreplay.controller;

import com.deutschland.springconceptreplay.Entity.Car;
import com.deutschland.springconceptreplay.Entity.User;
import com.deutschland.springconceptreplay.service.CarService;
import com.deutschland.springconceptreplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value="/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public User create(@RequestBody User user ){

        return userService.addUser(user) ;

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) throws Exception {
        userService.deleteUser(id);
    }

}
