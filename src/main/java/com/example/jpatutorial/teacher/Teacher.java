package com.example.jpatutorial.teacher;

import com.example.jpatutorial.course.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long id;
    private String name;
    private Integer age;

    @JsonIgnoreProperties("teacher")
    @OneToMany(mappedBy = "teacher")
//    @JoinColumn(name = "id", referencedColumnName = "id", nullable = true)
    private List<Course> courses;

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Teacher(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
