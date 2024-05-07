package com.microservice.course.business.port;

import com.microservice.course.domain.dto.response.StudentByCourseResponse;
import com.microservice.course.persistence.entity.CourseEntity;

import java.util.List;

public interface ICourseService {
    List<CourseEntity> findAllCourses();

    CourseEntity findCourseById(Long courseId);

    CourseEntity saveCourse(CourseEntity course);

    StudentByCourseResponse findStudentsByIdCourse(Long courseId);
}
