package com.microservice.course.persistence.repository;

import com.microservice.course.persistence.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoursePersistenceRepository extends JpaRepository<CourseEntity, Long> {

}
