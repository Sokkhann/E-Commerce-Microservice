package com.testing.user_service.service;

import com.testing.user_service.dto.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(String id);
    UserDto createUser(UserDto userDto);
    void deleteUser(String id);
}