package com.example.smartClassSystem.services;

import com.example.smartClassSystem.domain.model.Course;
import com.example.smartClassSystem.domain.model.Teacher;
import com.example.smartClassSystem.domain.repository.CourseRepository;
import com.example.smartClassSystem.domain.repository.TeacherRepository;
import com.example.smartClassSystem.dto.request.CourseRequest;
import com.example.smartClassSystem.dto.request.TeacherRequest;
import com.example.smartClassSystem.dto.response.IdentityResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public IdentityResponse createCourseByTeacher(String teacherId , CourseRequest courseRequest) {

        Optional<Teacher> teacherOptional = teacherRepository.findAllById(teacherId);
        Teacher teacher = teacherOptional.get();

        String uuid =UUID.randomUUID().toString();

        Course course = new Course();

        course.setId(uuid);
        course.setCourseCode(courseRequest.getCourseCode());
        course.setCourseName(courseRequest.getCourseName());
        course.setCourseDescription(courseRequest.getCourseDescription());
        course.setCourseCredit(courseRequest.getCourseCredit());
        course.setTeacher(teacher);

        courseRepository.saveAndFlush(course);


        return new IdentityResponse(uuid);


    }


}
