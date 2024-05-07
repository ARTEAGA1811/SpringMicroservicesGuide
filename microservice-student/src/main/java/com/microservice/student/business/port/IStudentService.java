package com.microservice.student.business.port;

import com.microservice.student.persistence.entity.StudentEntity;

import java.util.List;

public interface IStudentService {
    List<StudentEntity> findAllStudents();

    List<StudentEntity> findAllStudentsByCourseId(Long courseId);

    StudentEntity findStudentById(Long studentId);

    StudentEntity saveStudent(StudentEntity student);

}
