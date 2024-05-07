package com.microservice.course.rest.controller;

import com.microservice.course.business.port.ICourseService;
import com.microservice.course.domain.dto.response.StudentByCourseResponse;
import com.microservice.course.persistence.entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping
    public ResponseEntity<CourseEntity> saveCourse(@RequestBody CourseEntity course) {
        return ResponseEntity.ok(courseService.saveCourse(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEntity> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findCourseById(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseEntity>> getCourses() {
        return ResponseEntity.ok(courseService.findAllCourses());
    }

    @GetMapping("/{courseId}/students")
    public ResponseEntity<StudentByCourseResponse> getStudentsByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.findStudentsByIdCourse(courseId));
    }
}
