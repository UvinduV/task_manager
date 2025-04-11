package com.example.task_manager_backend.dao;

import com.example.task_manager_backend.entity.Impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
