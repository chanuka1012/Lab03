package com.example.lab03.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab03.Model.Student;
import com.example.lab03.Service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("/students")

public class StudentController {

    @Autowired
     private StudentService studentService;
  
     @GetMapping("/all/{year}")
     public ResponseEntity<List<Student>> getAllStudentsByYear(@PathVariable int year){
        
         List<Student> students = studentService.getStudentsByYear(year);
         return ResponseEntity.ok(students);
     }

     @GetMapping("/{id}/department")
        public String getDepartmentByStudentId(@PathVariable String id) {
           return studentService.findDepartmentById(id);
} 
       
    
     @PostMapping("/save")
     public ResponseEntity<Student> register(@RequestBody Student student){
        Student savedStudent = studentService.saveStudent(student);
         return ResponseEntity.ok(savedStudent);
     }

    
    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student UpdatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(UpdatedStudent);
    }

    @DeleteMapping("/deleteStudent")
    public boolean deleteStudent(@RequestBody Student student){
        return studentService.deleteStudent(student);
    }
}
