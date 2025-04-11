package com.example.task_manager_backend.controller;

import com.example.task_manager_backend.dto.Impl.TaskDTO;
import com.example.task_manager_backend.dto.TaskStatus;
import com.example.task_manager_backend.exeption.DataPersistExeption;
import com.example.task_manager_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveTask(@RequestBody TaskDTO taskDTO){ //serialization
        try {
            taskService.saveTask(taskDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistExeption e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDTO> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/{taskID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskStatus getSelectedTask(@PathVariable ("taskID") String taskId){
        return taskService.getSelectedTask(taskId);
    }
    @PutMapping(value = "/{taskId}")
    public ResponseEntity<Void> updateTask(@PathVariable ("taskId") String taskId,
                                           @RequestBody TaskDTO updatedTaskDTO){

        try {
            taskService.updateTask(taskId,updatedTaskDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
