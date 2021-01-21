package com.example.smartClassSystem.dto.response;

import com.example.smartClassSystem.domain.model.Course;
import com.example.smartClassSystem.dto.request.CourseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {

    private String teacherId;
    private String firstName;
    private String department;
    private String mobileNo;
    private String teacherDesignation;
    private String teacherExpertise;
    private List<CourseRequest> courseAvailable;
}
