package com.example.smartClassSystem.controller;

import com.example.smartClassSystem.dto.request.CourseRequest;
import com.example.smartClassSystem.dto.response.IdentityResponse;
import com.example.smartClassSystem.services.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/maintenance")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create/course/teacher/{id}")
    public ResponseEntity<IdentityResponse> createCalendar(@PathVariable String id, @RequestBody CourseRequest courseRequest) {

        return new ResponseEntity(courseService.createCourseByTeacher(id,courseRequest), HttpStatus.CREATED);
    }
}
