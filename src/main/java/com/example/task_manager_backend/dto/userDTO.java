package com.example.task_manager_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class userDTO implements userStatus{
    private Long userId;
    private String username;
    private String password;
}
