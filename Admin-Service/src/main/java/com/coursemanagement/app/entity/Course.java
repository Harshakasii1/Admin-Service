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
public class Course {

	 	@Id
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String description;

	    @ManyToMany(mappedBy = "courses")
	    private List<Instructor> instructors;

	    @ManyToMany(mappedBy = "courses")
	    private List<Student> students;

}
