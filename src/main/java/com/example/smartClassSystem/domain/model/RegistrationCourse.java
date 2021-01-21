package com.example.smartClassSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REGISTRATION_COURSE_BD")
public class RegistrationCourse {

    @Id
    private String id;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;



}
