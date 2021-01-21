package com.example.smartClassSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_BD")
public class Student {

    @Id
    private String id;

    private String studentId;
    private String studentName;
    private String department;
    private String mobileNo;
    private String currentSemester;
    private String password;

}
