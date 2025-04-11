package com.example.task_manager_backend.dto;

import com.example.task_manager_backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements UserStatus {
    private Long userId;
    private String username;
    private String password;
    private Role role;
}
