package com.coursemanagement.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coursemanagement.app.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
}
