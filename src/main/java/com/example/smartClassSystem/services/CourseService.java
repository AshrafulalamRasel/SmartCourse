package com.example.smartClassSystem.services;

import com.example.smartClassSystem.domain.model.Course;
import com.example.smartClassSystem.domain.model.Teacher;
import com.example.smartClassSystem.domain.repository.CourseRepository;
import com.example.smartClassSystem.domain.repository.TeacherRepository;
import com.example.smartClassSystem.dto.request.CourseRequest;
import com.example.smartClassSystem.dto.request.TeacherRequest;
import com.example.smartClassSystem.dto.response.IdentityResponse;
import com.example.smartClassSystem.dto.response.TeacherResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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


    public List<TeacherResponse> getAllCourse() {

        List<Course> courseOptional = courseRepository.findAll();


        List<TeacherResponse> teacherResponseArrayList = new ArrayList<>();

        for (Course courseRequest : courseOptional) {

            TeacherResponse teacherResponse = new TeacherResponse();
            teacherResponse.setTeacherId(courseRequest.getTeacher().getId());
            teacherResponse.setFirstName(courseRequest.getTeacher().getFirstName());
            teacherResponse.setMobileNo(courseRequest.getTeacher().getMobileNo());
            teacherResponse.setDepartment(courseRequest.getTeacher().getDepartment());
            teacherResponse.setTeacherDesignation(courseRequest.getTeacher().getTeacherDesignation());
            teacherResponse.setTeacherExpertise(courseRequest.getTeacher().getTeacherExpertise());
            teacherResponse.setId(courseRequest.getId());
            teacherResponse.setCourseCode(courseRequest.getCourseCode());
            teacherResponse.setCourseName(courseRequest.getCourseName());
            teacherResponse.setCourseDescription(courseRequest.getCourseDescription());
            teacherResponse.setCourseCredit(courseRequest.getCourseCredit());
            teacherResponseArrayList.add(teacherResponse);

        }

        return teacherResponseArrayList;
    }
}
