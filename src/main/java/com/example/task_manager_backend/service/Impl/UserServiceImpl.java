package com.example.task_manager_backend.service.Impl;

import com.example.task_manager_backend.dao.UserDao;
import com.example.task_manager_backend.dto.UserDTO;
import com.example.task_manager_backend.entity.Impl.User;
import com.example.task_manager_backend.exeption.DataPersistExeption;
import com.example.task_manager_backend.exeption.UserNotFoundExeption;
import com.example.task_manager_backend.service.UserService;
import com.example.task_manager_backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping userMapping;

    @Override
    public void createUser(UserDTO userDTO) {
        User createUser=userDao.save(userMapping.toUserEntity(userDTO));
        if (createUser == null){
            throw new DataPersistExeption("User creation failed");
        }

    }

    @Override
    public UserDetailsService userDetailsService() {
        return userName ->
                userDao.findByUsername(userName)
                        .orElseThrow(()-> new UserNotFoundExeption("User Not Found"));
    }

}
