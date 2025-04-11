package com.example.task_manager_backend.service.Impl;

import com.example.task_manager_backend.dao.TaskDao;
import com.example.task_manager_backend.dto.Impl.TaskDTO;
import com.example.task_manager_backend.entity.Impl.Task;
import com.example.task_manager_backend.exeption.DataPersistExeption;
import com.example.task_manager_backend.service.TaskService;
import com.example.task_manager_backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Autowired
    private Mapping taskMapping;

    @Override
    public void saveTask(TaskDTO taskDTO) {
        Task savedTask = taskDao.save(taskMapping.toTaskEntity(taskDTO));
        if(savedTask == null) {
            throw new DataPersistExeption("Task not saved");
        }
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskMapping.asTaskDTOList(taskDao.findAll());
    }
}
