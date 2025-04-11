package com.example.task_manager_backend.customStatusCode;

import com.example.task_manager_backend.dto.TaskStatus;
import com.example.task_manager_backend.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus, TaskStatus {
    private int statusCode;
    private String statusMassage;
}
