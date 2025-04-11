package com.example.task_manager_backend.exeption;

public class UserNotFoundExeption extends RuntimeException{
    public UserNotFoundExeption() {
    }
    public UserNotFoundExeption(String message) {
    }
    public UserNotFoundExeption(String message, Throwable cause) {
    }
}
