package com.example.smartClassSystem.services;


import com.example.smartClassSystem.domain.model.Student;
import com.example.smartClassSystem.domain.model.Teacher;
import com.example.smartClassSystem.domain.repository.StudentRepository;
import com.example.smartClassSystem.domain.repository.TeacherRepository;
import com.example.smartClassSystem.dto.request.StudentRequest;
import com.example.smartClassSystem.dto.request.TeacherRequest;
import com.example.smartClassSystem.dto.response.IdentityResponse;
import com.example.smartClassSystem.dto.response.TeacherResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StudentServices {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public IdentityResponse createStudent(StudentRequest studentRequest) {

        String uuid =UUID.randomUUID().toString();

        Student student = new Student();

        student.setId(uuid);
        student.setStudentId(studentRequest.getStudentId());
        student.setStudentName(studentRequest.getStudentName());
        student.setDepartment(studentRequest.getDepartment());
        student.setMobileNo(studentRequest.getMobileNo());
        student.setCurrentSemester(studentRequest.getCurrentSemester());
        student.setPassword(studentRequest.getPassword());

        studentRepository.saveAndFlush(student);

        return new IdentityResponse(uuid);

    }

    public List<TeacherRequest> getAllTeacher(){

        List<Teacher> teacherList = teacherRepository.findAll();
        List<TeacherRequest> teacherRequestList = new ArrayList<>();

        for (Teacher teacher : teacherList){
            teacherRequestList.add(new TeacherRequest(teacher.getId(),teacher.getTeacherId(),teacher.getFirstName(),teacher.getDepartment(),teacher.getMobileNo(),teacher.getTeacherDesignation(),teacher.getTeacherExpertise(),teacher.getPassword()));
        }



        return teacherRequestList;
    }
}
