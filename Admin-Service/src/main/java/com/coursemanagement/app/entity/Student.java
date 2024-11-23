package com.coursemanagement.app.entity;




import lombok.Data;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
@Data
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;
    private String name;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
      name = "course_students", 
      joinColumns = @JoinColumn(name = "student_id"), 
      inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    // Method to generate password based on studentId and courseId
    public void generatePassword() {
        this.password = this.studentId + "-" + this.id;  // Example: studentId + courseId (id)
    }
}
