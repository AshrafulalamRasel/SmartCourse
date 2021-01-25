package com.example.smartClassSystem.controller;

import com.example.smartClassSystem.dto.response.AttandeeResponse;
import com.example.smartClassSystem.services.AttendeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
@AllArgsConstructor
@CrossOrigin("*")
public class AttendeeController {
    private final AttendeeService attendeeService;

    @PostMapping("courses/{courseId}/students/{studentId}/days/{dayNo}")
    public String addAttendee(@PathVariable("courseId") String courseId,
                              @PathVariable("studentId") String studentId,
                              @PathVariable("dayNo") String dayNo)
    {
       return attendeeService.addAttendee(courseId,studentId,dayNo);
    }

    @GetMapping("courses/{courseId}/students/{studentId}/attendee")
    public ResponseEntity<List<AttandeeResponse>> addAttendee(@PathVariable("courseId") String courseId,
                                                              @PathVariable("studentId") String studentId)
    {
        return attendeeService.getAttendeeByCourseAndStudentId(courseId,studentId);
    }
}
