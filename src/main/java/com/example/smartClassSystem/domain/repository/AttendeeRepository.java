package com.example.smartClassSystem.domain.repository;

import com.example.smartClassSystem.domain.model.Attendee;
import com.example.smartClassSystem.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee,String> {


//    @Query("select from attendee_table where ")
    Optional<List<Attendee>> findAllByCourseIdAndStudentId(String courseId, String studentId);

}
