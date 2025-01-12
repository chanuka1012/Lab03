package com.example.lab03.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.lab03.Model.Student;

public interface StudentRepo extends MongoRepository<Student ,String>{
    List<Student> findByYearOfEnrollment(int yearOfEnrollment);

}
