package com.example.task_manager_backend.service;

import com.example.task_manager_backend.dto.UserDTO;

public interface UserService {
    void createUser(UserDTO userDTO);
}
