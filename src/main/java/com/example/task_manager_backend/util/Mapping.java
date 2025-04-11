package com.example.task_manager_backend.util;

import com.example.task_manager_backend.dto.Impl.TaskDTO;
import com.example.task_manager_backend.dto.Impl.UserDTO;
import com.example.task_manager_backend.entity.Impl.Task;
import com.example.task_manager_backend.entity.Impl.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public User toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
    public UserDTO toUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public Task toTaskEntity(TaskDTO taskDTO){
        return modelMapper.map(taskDTO, Task.class);
    }
    public TaskDTO toTaskDTO(Task task){
        return modelMapper.map(task, TaskDTO.class);
    }
    public List<TaskDTO> asTaskDTOList(List<Task> taskEntities) {
        return modelMapper.map(taskEntities, new TypeToken<List<TaskDTO>>() {}.getType());
    }
}
