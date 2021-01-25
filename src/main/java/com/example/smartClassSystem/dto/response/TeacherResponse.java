package com.example.smartClassSystem.dto.response;

import com.example.smartClassSystem.domain.model.Course;
import com.example.smartClassSystem.domain.model.Teacher;
import com.example.smartClassSystem.dto.request.CourseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    private String id;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    private String courseCredit;



}
