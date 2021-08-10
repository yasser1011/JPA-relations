package com.example.jpatutorial.coursematerial;

import com.example.jpatutorial.course.Course;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "material_sequence", sequenceName = "material_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_sequence")
    private Long id;
    private String url;

    @JsonIgnoreProperties("courseMaterial")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    // name is what you want to name the foreign column and referenced is the primary key name(camel case) in the other class
    // if primary key in the other class is courseId referencedColumnName = courseId
    private Course course;

    public CourseMaterial(){}

    public CourseMaterial(String url, Course course) {
        this.url = url;
        this.course = course;
    }

    public CourseMaterial(Long id, String url,Course course) {
        this.id = id;
        this.url = url;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(Course course){
        this.course = course;
    }

}
