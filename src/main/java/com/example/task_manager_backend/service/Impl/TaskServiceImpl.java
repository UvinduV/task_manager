package com.example.task_manager_backend.service.Impl;

import com.example.task_manager_backend.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.task_manager_backend.dao.TaskDao;
import com.example.task_manager_backend.dto.Impl.TaskDTO;
import com.example.task_manager_backend.dto.TaskStatus;
import com.example.task_manager_backend.entity.Impl.Task;
import com.example.task_manager_backend.exeption.DataPersistExeption;
import com.example.task_manager_backend.exeption.NoteNotFoundExeption;
import com.example.task_manager_backend.service.TaskService;
import com.example.task_manager_backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public TaskStatus getSelectedTask(String taskId) {
        if(taskDao.existsById(taskId)){
            var selectedTask = taskDao.getReferenceById(taskId);
            return taskMapping.toTaskDTO(selectedTask);
        }else {
            return new SelectedUserAndNoteErrorStatus(2,"Selected Task is not found");
        }
    }

    @Override
    public void updateTask(String taskId, TaskDTO updatedTaskDTO) {
        Optional<Task> findTask=taskDao.findById(taskId);
        if (!findTask.isPresent()){
            throw new NoteNotFoundExeption("task with id " + taskId + " not found");
        }else {
            findTask.get().setTitle(updatedTaskDTO.getTitle());
            findTask.get().setDescription(updatedTaskDTO.getDescription());
            findTask.get().setStatus(updatedTaskDTO.getStatus());
            findTask.get().setCreatedAt(updatedTaskDTO.getCreatedAt());

        }

    }
}
