package com.example.task_manager_backend.customStatusCode;

import com.example.task_manager_backend.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus {
    private int statusCode;
    private String statusMassage;
}
