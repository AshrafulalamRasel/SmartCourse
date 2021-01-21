package com.example.smartClassSystem.dto.request;

import com.example.smartClassSystem.domain.model.Teacher;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestList {

    private String courseCode;
    private String courseName;
    private String courseCredit;
   private List<TeacherRequestList> teacherList = new ArrayList<>();
}
