package com.example.smartClassSystem.domain.repository;

import com.example.smartClassSystem.domain.model.Student;
import com.example.smartClassSystem.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    Optional<Student> findAllById(String id);
    Optional<Student> findAllByStudentIdAndPassword(String id,String password);

    List<Student> findAllByStudentId(String id);
}
