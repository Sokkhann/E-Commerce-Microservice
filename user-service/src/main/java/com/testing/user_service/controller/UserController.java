package com.testing.user_service.controller;

import com.testing.user_service.dto.UserDto;
import com.testing.user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello User Service!";
    }

    @GetMapping("/token")
    public String token(@RequestHeader("Authorization") String auth) {
        return auth;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/me")
    public Principal getMe(Principal principal) {
        return principal;
    }

    @GetMapping("/debug-token")
    public String debugToken() {
        return "Token accepted by user-service";
    }
}
