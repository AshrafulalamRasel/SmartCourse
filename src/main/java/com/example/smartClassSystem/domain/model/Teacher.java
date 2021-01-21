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
@Table(name = "TEACHER_BD")
public class Teacher {

    @Id
    private String id;

    private String teacherId;
    private String firstName;
    private String department;
    private String mobileNo;
    private String teacherDesignation;
    private String teacherExpertise;
    private String password;


}
