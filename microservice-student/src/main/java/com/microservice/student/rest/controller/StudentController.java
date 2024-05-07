package com.microservice.student.rest.controller;

import com.microservice.student.business.port.IStudentService;
import com.microservice.student.persistence.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping
    public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentEntity student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentEntity> findById(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.findStudentById(studentId));
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

//    @GetMapping("/course/{courseId}")
//    public ResponseEntity<List<StudentEntity>> findAllByCourseId(@PathVariable Long courseId) {
//        return ResponseEntity.ok(studentService.findAllStudentsByCourseId(courseId));
//    }


    //Enable an endpoint to communicate with the microservice-course
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<StudentEntity>> findAllByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(studentService.findAllStudentsByCourseId(courseId));
    }

}
