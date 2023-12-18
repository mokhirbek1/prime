package com.example.studyplatform.security.dto;

import com.example.studyplatform.entity.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String phoneNumber;
    private String password;
    private UserRole userRole;
}
