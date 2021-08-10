package com.example.jpatutorial.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s")
    List<StudentLimited> getStudentsIdsAndNames();

    @Query("select s from Student s where s.guardian.name = ?1")
    List<Student> findByGuardianName(String guardianName);

    List<Student> findByEmail(String email);

    List<Student> findByEmailContaining(String email);
}
