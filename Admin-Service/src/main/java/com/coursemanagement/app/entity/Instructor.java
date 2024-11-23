package com.coursemanagement.app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Instructor {

	 @Id
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String email;
	    private String password;

	    @ManyToMany
	    @JoinTable(
	        name = "course_instructor", // The join table name
	        joinColumns = @JoinColumn(name = "instructor_id"), // The column for the instructor
	        inverseJoinColumns = @JoinColumn(name = "course_id") // The column for the course
	    )
	    private List<Course> courses;

	    // Method to generate password based on instructor's name and id
	    public void generatePassword() {
	        this.password = this.name + "-" + this.id;  // Example: "Harsha-200"
	    }
    // Getters and Setters
   
}
