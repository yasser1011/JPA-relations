package com.example.jpatutorial.course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @GetMapping()
    public List<Course> findCourses(){
        for (Course course: courseRepository.findAll()) {
            System.out.println("course = " + course);
        }
        return courseRepository.findAll();
    }
}
