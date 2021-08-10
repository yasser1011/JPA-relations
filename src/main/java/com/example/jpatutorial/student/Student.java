package com.example.jpatutorial.student;

import com.example.jpatutorial.course.Course;
import com.example.jpatutorial.guardian.Guardian;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.security.Guard;
import java.util.List;

@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;

    @Column(nullable = false, name = "email_address", unique = true)
    private String email;
    @Embedded
    private Guardian guardian;

    @JsonIgnoreProperties("students")
    @ManyToMany(mappedBy = "students")
    //the property in the other class not the table name
    private List<Course> courses;

    public Student(){}

    public Student(Long id, String name, String email, String guardianName, String guardianEmail, String guardianMobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.guardian = new Guardian(guardianName,guardianMobile, guardianEmail);
    }

    public Student(String name, String email, String guardianName, String guardianEmail, String guardianMobile) {
        this.name = name;
        this.email = email;
        this.guardian = new Guardian(guardianName,guardianMobile, guardianEmail);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }


}
