package com.example.smartClassSystem.dto.request;

import com.example.smartClassSystem.domain.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private String id;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    private String courseCredit;
}
