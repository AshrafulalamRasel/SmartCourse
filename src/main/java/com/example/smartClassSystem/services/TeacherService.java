package com.example.smartClassSystem.services;

import com.example.smartClassSystem.domain.model.Course;
import com.example.smartClassSystem.domain.model.Student;
import com.example.smartClassSystem.domain.model.Teacher;
import com.example.smartClassSystem.domain.repository.CourseRepository;
import com.example.smartClassSystem.domain.repository.StudentRepository;
import com.example.smartClassSystem.domain.repository.TeacherRepository;
import com.example.smartClassSystem.dto.request.CourseRequest;
import com.example.smartClassSystem.dto.request.LoginRequest;
import com.example.smartClassSystem.dto.request.TeacherRequest;
import com.example.smartClassSystem.dto.response.IdentityResponse;
import com.example.smartClassSystem.dto.response.LoginResponse;
import com.example.smartClassSystem.dto.response.StudentResponse;
import com.example.smartClassSystem.dto.response.TeacherResponse;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import java.util.*;

@AllArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public IdentityResponse createTeacher(TeacherRequest teacherRequest) {

        String uuid =UUID.randomUUID().toString();

        Teacher teacher = new Teacher();

        teacher.setId(uuid);
        teacher.setTeacherId(teacherRequest.getTeacherId());
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setDepartment(teacherRequest.getDepartment());
        teacher.setMobileNo(teacherRequest.getMobileNo());
        teacher.setTeacherDesignation(teacherRequest.getTeacherDesignation());
        teacher.setTeacherExpertise(teacherRequest.getTeacherExpertise());
        teacher.setPassword(teacherRequest.getPassword());

        teacherRepository.saveAndFlush(teacher);

        return new IdentityResponse(uuid);


    }

    public LoginResponse signIn(LoginRequest loginRequest){
        LoginResponse loginResponse = new LoginResponse();
        Optional<Teacher>  teacherOptional = teacherRepository.findAllByTeacherIdAndPassword(loginRequest.getId(),loginRequest.getPassword());

        if (teacherOptional.isPresent()){

            Teacher teacher = teacherOptional.get();
            loginResponse.setId(teacher.getId());
            loginResponse.setName(teacher.getFirstName());
            loginResponse.setMobileNo(teacher.getMobileNo());
            loginResponse.setRole("faculty");
            return loginResponse;
        }
        else if (!teacherOptional.isPresent()){

            Optional<Student>  studentOptional = studentRepository.findAllByStudentIdAndPassword(loginRequest.getId(),loginRequest.getPassword());
            Student student = studentOptional.get();
            loginResponse.setId(student.getId());
            loginResponse.setName(student.getStudentName());
            loginResponse.setMobileNo(student.getMobileNo());
            loginResponse.setRole("faculty");
            return loginResponse;
        }

        return null;
    }





    public TeacherResponse getAllTeacherInformation(String teacherId){

        Optional<Teacher> teacherOptional =teacherRepository.findAllById(teacherId);
        List<Course> courseOptional =courseRepository.findAllByTeacherId(teacherId);


        TeacherResponse teacherResponse = new TeacherResponse();

        teacherResponse.setTeacherId(teacherOptional.get().getTeacherId());
        teacherResponse.setFirstName(teacherOptional.get().getDepartment());
        teacherResponse.setMobileNo(teacherOptional.get().getMobileNo());
        teacherResponse.setDepartment(teacherOptional.get().getDepartment());
        teacherResponse.setTeacherDesignation(teacherOptional.get().getTeacherDesignation());
        teacherResponse.setTeacherExpertise(teacherOptional.get().getTeacherExpertise());


        List<CourseRequest> courseList = new ArrayList<>();

        for (Course courseRequest :courseOptional){

            CourseRequest courseRequest1 = new CourseRequest();

            courseRequest1.setId(courseRequest.getId());
            courseRequest1.setCourseCode(courseRequest.getCourseCode());
            courseRequest1.setCourseName(courseRequest.getCourseName());
            courseRequest1.setCourseDescription(courseRequest.getCourseDescription());
            courseRequest1.setCourseCredit(courseRequest.getCourseCredit());

            courseList.add(courseRequest1);
        }



        teacherResponse.setCourseAvailable(courseList);




        return teacherResponse;
    }


    public ResponseEntity<String> updateTeacherProfile(String id,TeacherRequest teacherRequest){

        Optional<Teacher>  teacherOptional = teacherRepository.findAllById(id);

        Teacher teacher = teacherOptional.get();

        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setMobileNo(teacherRequest.getMobileNo());
        teacher.setDepartment(teacherRequest.getDepartment());
        teacher.setTeacherExpertise(teacherRequest.getTeacherExpertise());
        teacher.setTeacherDesignation(teacherRequest.getTeacherDesignation());

        teacherRepository.save(teacher);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


    public ResponseEntity<String> deleteTeacherProfile(String id){

        Optional<Teacher>  teacherOptional = teacherRepository.findAllById(id);

        if (!teacherOptional.isPresent()) {
            throw new RuntimeException("Teacher not found.");
        }
        teacherRepository.delete(teacherOptional.get());
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
