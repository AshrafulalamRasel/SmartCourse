package com.example.smartClassSystem.domain.repository;

import com.example.smartClassSystem.domain.model.Student;
import com.example.smartClassSystem.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String> {

    Optional<Teacher> findAllById(String id);

    Optional<Teacher>  findAllByTeacherIdAndPassword(String id,String password);
}
