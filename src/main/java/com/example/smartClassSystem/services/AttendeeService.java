package com.example.smartClassSystem.services;

import com.example.smartClassSystem.domain.model.Attendee;
import com.example.smartClassSystem.domain.repository.AttendeeRepository;
import com.example.smartClassSystem.dto.response.AttandeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;
    public String addAttendee(String courseId, String studentId, String dayNo) {
        String id = UUID.randomUUID().toString();
        Attendee attendee = new Attendee();
        attendee.setId(id);
        attendee.setCourseId(courseId);
        attendee.setStudentId(studentId);
        attendee.setDayNo(dayNo);
        attendeeRepository.save(attendee);
        return id;
    }

    public ResponseEntity<List<AttandeeResponse>> getAttendeeByCourseAndStudentId(String courseId, String studentId) {
        List<AttandeeResponse> attendeeResponseList = new ArrayList<>();
        Optional<List<Attendee>> attendeeList = attendeeRepository.findAllByCourseIdAndStudentId(courseId,studentId);
        if(!attendeeList.isPresent())
        {
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }

        for(Attendee attendee: attendeeList.get()) {
            AttandeeResponse attandeeResponse = new AttandeeResponse();
            attandeeResponse.setClassNo(attendee.getDayNo());
            attandeeResponse.setStatus("Present");
            attendeeResponseList.add(attandeeResponse);
        }
        return new ResponseEntity(attendeeResponseList,HttpStatus.OK);
    }
}
