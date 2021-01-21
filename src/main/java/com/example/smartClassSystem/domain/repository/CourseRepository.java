package com.example.smartClassSystem.domain.repository;

import com.example.smartClassSystem.domain.model.Course;
import com.example.smartClassSystem.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

    List<Course> findAllByTeacherId(String id);
    List<Course> findAllByCourseCode(String id);
    Optional<Course> findAllById(String id);
}
