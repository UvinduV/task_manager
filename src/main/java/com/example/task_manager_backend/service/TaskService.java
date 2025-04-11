package com.example.task_manager_backend.service;

import com.example.task_manager_backend.dto.Impl.TaskDTO;
import com.example.task_manager_backend.dto.TaskStatus;

import java.util.List;

public interface TaskService {
    void saveTask(TaskDTO taskDTO);

    List<TaskDTO> getAllTasks();

    TaskStatus getSelectedTask(String taskId);

    void updateTask(String taskId, TaskDTO updatedTaskDTO);
}
