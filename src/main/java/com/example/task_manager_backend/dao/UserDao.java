package com.example.task_manager_backend.dao;

import com.example.task_manager_backend.entity.Impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
}
