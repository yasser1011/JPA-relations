package com.example.jpatutorial.coursematerial;

import com.example.jpatutorial.course.Course;
import com.example.jpatutorial.student.Student;
import com.example.jpatutorial.student.StudentRepository;
import com.example.jpatutorial.teacher.Teacher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseMaterialConfig {
    @Bean
    CommandLineRunner commandLineRunner1(CourseMaterialRepository repository){
        return args -> {
            Teacher newTeacher = new Teacher("teacher1", 32);
            Course newCourse = new Course("DSA", 6, newTeacher);
            CourseMaterial newMaterial = new CourseMaterial("DSA.com", newCourse);

            repository.save(newMaterial);
        };
    }
}
