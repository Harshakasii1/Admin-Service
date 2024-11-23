package com.coursemanagement.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class InstructorDTO {
	 private Long id;
	    private String name;
	    private String email;
	    private String password;
	    private List<Long> courseIds;

	    public InstructorDTO(Long id, String name, String email, String password, List<Long> courseIds) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.password = password;
	        this.courseIds = courseIds;
	    }

}
