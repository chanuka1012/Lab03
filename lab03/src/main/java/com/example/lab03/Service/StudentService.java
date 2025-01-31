package com.example.lab03.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.lab03.Model.Student;
import com.example.lab03.Repo.StudentRepo;

@Service
@Transactional

public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    public List<Student> getStudentsByYear(int year){
        return studentRepo.findByYearOfEnrollment(year);
    }

    public String findDepartmentById(String id) {
        return studentRepo.findDepartmentById(id);
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    
    public void deleteByYearOfEnrollment(int year) {
        studentRepo.deleteByYearOfEnrollment(year);
    }


}
