package com.example.task_manager_backend.service;

import com.example.task_manager_backend.dto.Impl.TaskDTO;

public interface TaskService {
    void saveTask(TaskDTO taskDTO);
}
