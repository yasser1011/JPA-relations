package com.example.jpatutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentRepository studentRepository;
    @Autowired
    StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping()
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/ids")
    public List<StudentLimited> findAllStudentIdsAndNames(){
        return studentRepository.getStudentsIdsAndNames();
    }

    @GetMapping(path = "/guardianName")
    public List<Student> findAllStudentByGuardianName(){
        return studentRepository.findByGuardianName("abooh");
    }

    @GetMapping(path = "/email")
    public List<Student> findAllStudentByEmail(){
        return studentRepository.findByEmail("salah@gmail.com");
    }

    @PutMapping()
    @Modifying
    @Transactional
    public void deleteFirstStudent(){
        Student firstStudent = studentRepository.findById(1L)
                .orElseThrow(() -> new IllegalStateException("student not found"));

        firstStudent.setEmail("newemail@gmail");
        firstStudent.setName("new name");
    }
}
