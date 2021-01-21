package com.example.smartClassSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestList {

    private String studentId;
    private String studentName;
    private String department;
    private String currentSemester;
}
