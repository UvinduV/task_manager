package com.example.task_manager_backend.exeption;

public class NoteNotFoundExeption extends RuntimeException{
    public NoteNotFoundExeption(){
    }
    public NoteNotFoundExeption(String message ){
    }
    public NoteNotFoundExeption(String message, Throwable cause){
    }
}
