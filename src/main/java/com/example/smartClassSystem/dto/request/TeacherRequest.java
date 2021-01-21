package com.example.smartClassSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {

    private String id;
    private String teacherId;
    private String firstName;
    private String department;
    private String mobileNo;
    private String teacherDesignation;
    private String teacherExpertise;
    private String password;
}
