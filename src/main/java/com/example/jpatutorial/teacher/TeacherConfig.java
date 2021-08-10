package com.example.jpatutorial.teacher;

import com.example.jpatutorial.student.Student;
import com.example.jpatutorial.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeacherConfig {
    private TeacherRepository teacherRepository;

    @Autowired
    TeacherConfig(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner2(TeacherRepository teacherRepository){
        return args -> {
            Teacher newTeacher = new Teacher("teacher3", 30);
            teacherRepository.save(newTeacher);
        };
    }
}
