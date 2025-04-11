package com.example.task_manager_backend.util;

import com.example.task_manager_backend.dto.UserDTO;
import com.example.task_manager_backend.entity.Impl.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
