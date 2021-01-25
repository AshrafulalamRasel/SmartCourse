package com.example.smartClassSystem.domain.repository;

import com.example.smartClassSystem.domain.model.RegistrationCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationCourseRepository extends JpaRepository<RegistrationCourse, String> {

    List<RegistrationCourse> findAllByStudentId(String id);
    List<RegistrationCourse> findAllByCourseId(String id);

}
