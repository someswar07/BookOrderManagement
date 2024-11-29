package org.personal.controllers;

import org.personal.bookstore.UserInfoService;
import org.personal.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserInfoService userInfoService;

    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping(path = "/register")
    public CompletableFuture<String> addUser(@RequestBody User user) {
        return userInfoService.addUser(user)
                .thenApply(v -> "User added successfully!")
                .exceptionally(e -> "Failed to add user: " + e.getMessage());
    }
}
