package com.microservice.course.client;

import com.microservice.course.domain.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Es el nombre que está en el application.yml del microservicio al que se va a conectar
@FeignClient(name = "msvc-student", url = "http://localhost:8090/api/students")
public interface StudentClient {

    @GetMapping("/course/{courseId}")
    List<StudentDTO> findAllStudentsByCourseId(@PathVariable Long courseId);
}
