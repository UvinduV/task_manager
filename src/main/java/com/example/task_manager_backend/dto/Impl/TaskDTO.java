package com.example.task_manager_backend.dto.Impl;
import com.example.task_manager_backend.dto.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO implements TaskStatus {
    private Long taskId;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
}
