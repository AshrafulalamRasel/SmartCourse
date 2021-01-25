package com.example.smartClassSystem.controller;

import com.example.smartClassSystem.dto.request.RegistrationCourseRequest;
import com.example.smartClassSystem.dto.request.StudentRequest;
import com.example.smartClassSystem.dto.response.IdentityResponse;
import com.example.smartClassSystem.services.StudentRegistrationCourseServices;
import com.example.smartClassSystem.services.StudentServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/maintenance")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RegistrationCourseController {

    private final StudentRegistrationCourseServices studentRegistrationCourseServices;

    @PostMapping("/student/registration/by/{studentId}/teacher/{teacherId}/course/{courseId}")
    public ResponseEntity<IdentityResponse> registrationCourse(@PathVariable("studentId") String studentId,@PathVariable("teacherId") String teacherId, @PathVariable("courseId") String courseId) {

        return new ResponseEntity(studentRegistrationCourseServices.registrationOnCourseByTeacherAndCourseId(studentId,teacherId,courseId), HttpStatus.CREATED);
    }

    @GetMapping("/getAll/registration/course/by/student/{id}")
    public ResponseEntity<List<RegistrationCourseRequest>> getAllRegistrationCourse(@PathVariable String id) {

        return new ResponseEntity(studentRegistrationCourseServices.getAllStudentRegistrationCoursesByStudentId(id), HttpStatus.OK);
    }

}
