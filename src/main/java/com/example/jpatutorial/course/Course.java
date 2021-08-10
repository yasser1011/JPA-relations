package com.example.jpatutorial.course;

import com.example.jpatutorial.coursematerial.CourseMaterial;
import com.example.jpatutorial.student.Student;
import com.example.jpatutorial.teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long id;
    private String title;
    private Integer credits;

    @JsonIgnoreProperties("course")
    @OneToOne(
            mappedBy = "course"
//            fetch = FetchType.EAGER
    )
    private CourseMaterial courseMaterial;

    @JsonIgnoreProperties("courses")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = true)
    private Teacher teacher;

    @JsonIgnoreProperties("courses")
    @ManyToMany
    @JoinTable(
            name = "student_course_map",
            //first one is the same class(course) - second is the other class(student)
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    private List<Student> students;

    public Course(){}

    public Course(String title, Integer credits, Teacher teacher) {
        this.title = title;
        this.credits = credits;
        this.teacher = teacher;
//        this.courseMaterial = courseMaterial;
    }

    public Course(Long id, String title, Integer credits, Teacher teacher) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.teacher = teacher;
//        this.courseMaterial = courseMaterial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void setCourseMaterial(CourseMaterial courseMaterial){
        this.courseMaterial = courseMaterial;
    }

    public CourseMaterial getCourseMaterial(){
        return courseMaterial;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public Teacher getTeacher(){
        return teacher;
    }

}
