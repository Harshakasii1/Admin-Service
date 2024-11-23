package com.coursemanagement.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.app.dto.CourseDTO;
import com.coursemanagement.app.entity.Course;
import com.coursemanagement.app.entity.Instructor;
import com.coursemanagement.app.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
    private CourseRepository courseRepository;

    // Convert Course entity to CourseDTO
    private CourseDTO convertToDTO(Course course) {
        List<Long> instructorIds = course.getInstructors().stream()
            .map(Instructor::getId)
            .collect(Collectors.toList());
        
        return new CourseDTO(course.getId(), course.getName(), course.getDescription(), instructorIds);
    }

    // Convert CourseDTO to Course entity
    private Course convertToEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        
        // Normally you would load instructors from the database based on the IDs,
        // but for simplicity, we are assuming the instructor list will be handled separately
        return course;
    }

    // Create a new course
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return convertToDTO(savedCourse);
    }

    // Get all courses
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get course by ID
    public CourseDTO getCourseById(Long courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            return convertToDTO(courseOptional.get());
        }
        return null; // Or throw an exception if not found
    }

    // Update an existing course
    public CourseDTO updateCourse(Long courseId, CourseDTO courseDetails) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setName(courseDetails.getName());
            course.setDescription(courseDetails.getDescription());
            // Here you might want to handle instructor relationships, which are not done in this simplified version
            Course updatedCourse = courseRepository.save(course);
            return convertToDTO(updatedCourse);
        }
        return null; // or throw exception
    }

    // Delete a course
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}