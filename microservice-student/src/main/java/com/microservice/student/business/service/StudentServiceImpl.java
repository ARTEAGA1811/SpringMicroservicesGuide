package com.microservice.student.business.service;

import com.microservice.student.business.port.IStudentService;
import com.microservice.student.persistence.entity.StudentEntity;
import com.microservice.student.persistence.repository.IStudentPersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentPersistenceRepository studentRepository;

    @Override
    public List<StudentEntity> findAllStudents() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        return studentEntityList;
    }

    @Override
    public List<StudentEntity> findAllStudentsByCourseId(Long courseId) {
        return studentRepository.findAllByCourseId(courseId);
    }

    @Override
    public StudentEntity findStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow();
    }

    @Override
    public StudentEntity saveStudent(StudentEntity student) {
        return studentRepository.save(student);
    }
}
