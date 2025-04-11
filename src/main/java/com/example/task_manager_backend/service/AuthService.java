package com.example.task_manager_backend.service;

import com.example.task_manager_backend.dto.Impl.UserDTO;
import com.example.task_manager_backend.secure.JWTAuthResponse;
import com.example.task_manager_backend.secure.SignIn;

public interface AuthService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(UserDTO userDTO);
    JWTAuthResponse refreshToken(String accessToken);
}
