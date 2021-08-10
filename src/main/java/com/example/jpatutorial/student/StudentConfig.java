package com.example.jpatutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    private StudentRepository studentRepository;

    @Autowired
    StudentConfig(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student salah = new Student("salah", "salah@gmail.com","abooh", "abooh@gmail", "0212");
            Student salah2 = new Student("salah2", "salah2@gmail.com", "abooh2", "abooh2@gmail", "23124");
            repository.saveAll(List.of(salah, salah2));
        };
    }
}
