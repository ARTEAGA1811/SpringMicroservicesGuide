package com.microservice.course.business.service;

import com.microservice.course.business.port.ICourseService;
import com.microservice.course.client.StudentClient;
import com.microservice.course.domain.dto.StudentDTO;
import com.microservice.course.domain.dto.response.StudentByCourseResponse;
import com.microservice.course.persistence.entity.CourseEntity;
import com.microservice.course.persistence.repository.ICoursePersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICoursePersistenceRepository courseRepository;
    @Autowired
    private StudentClient studentClient;

    @Override
    public List<CourseEntity> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public CourseEntity findCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow();
    }

    @Override
    public CourseEntity saveCourse(CourseEntity course) {
        return courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long courseId) {
        CourseEntity course = courseRepository.findById(courseId).orElseThrow();

        //Para consultar los estudiantes tengo que acceder al microservice de estudiantes
        List<StudentDTO> students = studentClient.findAllStudentsByCourseId(courseId);
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .students(students)
                .build();
    }
}
