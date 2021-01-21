package com.example.smartClassSystem.services;


import com.example.smartClassSystem.domain.model.Course;
import com.example.smartClassSystem.domain.model.RegistrationCourse;
import com.example.smartClassSystem.domain.model.Student;
import com.example.smartClassSystem.domain.model.Teacher;
import com.example.smartClassSystem.domain.repository.CourseRepository;
import com.example.smartClassSystem.domain.repository.RegistrationCourseRepository;
import com.example.smartClassSystem.domain.repository.StudentRepository;
import com.example.smartClassSystem.domain.repository.TeacherRepository;
import com.example.smartClassSystem.dto.request.CourseRequestList;
import com.example.smartClassSystem.dto.request.RegistrationCourseRequest;
import com.example.smartClassSystem.dto.request.StudentRequestList;
import com.example.smartClassSystem.dto.request.TeacherRequestList;
import com.example.smartClassSystem.dto.response.IdentityResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StudentRegistrationCourseServices {

    private final RegistrationCourseRepository registrationCourseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    public IdentityResponse registrationOnCourseByTeacherAndCourseId(String studentId, String teacherId, String courseId) {

        Optional<Teacher> teacherOptional = teacherRepository.findAllById(teacherId);
        Teacher teacher = teacherOptional.get();

        Optional<Course> courseOptional = courseRepository.findAllById(courseId);
        Course course = courseOptional.get();

        Optional<Student> studentOptional = studentRepository.findAllById(studentId);
        Student student = studentOptional.get();

        String uuid = UUID.randomUUID().toString();

        RegistrationCourse registrationCourse = new RegistrationCourse();


        registrationCourse.setId(uuid);
        registrationCourse.setTeacher(teacher);
        registrationCourse.setCourse(course);
        registrationCourse.setStudent(student);

        registrationCourseRepository.saveAndFlush(registrationCourse);

        return new IdentityResponse(uuid);
    }

    public List<RegistrationCourseRequest> getAllStudentRegistrationCoursesByStudentId(String id) {


        String studentId = null;
        List<String> courseId = new ArrayList<>();

        List<RegistrationCourseRequest> registrationCourseRequestList = new ArrayList<>();

        List<RegistrationCourse> registrationCourseOptional = registrationCourseRepository.findAllByStudentId(id);


        for (RegistrationCourse registrationCourse : registrationCourseOptional) {


            studentId = registrationCourse.getStudent().getStudentId();
            courseId.add(registrationCourse.getCourse().getId());

        }


        List<StudentRequestList> studentRequestLists = new ArrayList<>();

        List<Student> studentOptional = studentRepository.findAllByStudentId(studentId);
        for (Student student : studentOptional) {
            studentRequestLists.add(new StudentRequestList(student.getStudentId(), student.getStudentName(), student.getDepartment(), student.getCurrentSemester()));
        }

        List<TeacherRequestList> teacherRequestLists = new ArrayList<>();
        List<CourseRequestList> courseRequestListList = new ArrayList<>();

        for (String mm : courseId) {

              Optional<Course> courseOptional = courseRepository.findAllById(mm);

                TeacherRequestList teacherRequestList = new TeacherRequestList();

                teacherRequestList.setTeacherId(courseOptional.get().getTeacher().getTeacherId());
                teacherRequestList.setFirstName(courseOptional.get().getTeacher().getFirstName());
                teacherRequestList.setDepartment(courseOptional.get().getTeacher().getDepartment());
                teacherRequestList.setTeacherDesignation(courseOptional.get().getTeacher().getTeacherDesignation());

                teacherRequestLists.add(teacherRequestList);


            courseRequestListList.add(new CourseRequestList(courseOptional.get().getCourseCode(), courseOptional.get().getCourseName(), courseOptional.get().getCourseCredit(), teacherRequestLists));
            new TeacherRequestList();
        }

        registrationCourseRequestList.add(new RegistrationCourseRequest(studentRequestLists, courseRequestListList));

        return registrationCourseRequestList;

    }


}
