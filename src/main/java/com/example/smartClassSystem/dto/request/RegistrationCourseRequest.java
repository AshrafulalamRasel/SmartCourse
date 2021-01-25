package com.example.smartClassSystem.dto.request;

import com.example.smartClassSystem.domain.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationCourseRequest {

 private String studentId;
 private String studentName;
 private String department;
 private String currentSemester;

}
