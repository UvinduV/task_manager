package com.example.task_manager_backend.service;

import com.example.task_manager_backend.dto.Impl.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    void createUser(UserDTO userDTO);
    UserDetailsService userDetailsService();
}
