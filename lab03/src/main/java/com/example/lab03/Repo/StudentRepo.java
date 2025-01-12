package com.example.lab03.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lab03.Model.Student;

public interface StudentRepo extends MongoRepository<Student ,String>{
    List<Student> findByYearOfEnrollment(int yearOfEnrollment);

    @Query("SELECT s.department FROM Student s WHERE s.id = :studentId")
    String findDepartmentById(@Param("studentId") String studentId);

    void deleteByYearOfEnrollment(int yearOfEnrollment);

}
