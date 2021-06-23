package com.doggy.DatabaseCon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping(path = "login/user")

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("{username}/{password}")
    public Optional<User> getUser(@PathVariable(value ="username")String username,
                                  @PathVariable(value ="password")String password) {

        return userService.getUser(username,password);
    }

    @PostMapping
    public Response registerNewUser(@RequestBody User user){

        return userService.logUser(user);
    }

    @PostMapping("register")
    public Response addNewUserToDb(@RequestBody User user){
        return userService.addNewUser(user);
    }

    @DeleteMapping(value = "{userUsername}/{password}")
    public void deleteUser(@PathVariable(value ="userUsername")String userUsername,
                           @PathVariable(value ="password")String password){
        userService.deleteUser(userUsername,password);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password){
        userService.updateUser(userId, username,password);
    }


}
