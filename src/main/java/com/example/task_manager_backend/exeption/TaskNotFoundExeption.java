package com.example.task_manager_backend.exeption;

public class TaskNotFoundExeption extends RuntimeException{
    public TaskNotFoundExeption(){
    }
    public TaskNotFoundExeption(String message ){
    }
    public TaskNotFoundExeption(String message, Throwable cause){
    }
}
