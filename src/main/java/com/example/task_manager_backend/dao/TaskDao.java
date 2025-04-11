package com.example.task_manager_backend.dao;

import com.example.task_manager_backend.entity.Impl.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task, String> {
}
