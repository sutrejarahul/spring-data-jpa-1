package com.jpa.example.repository;

import com.jpa.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByRollNo(int rollNo);

    //	@Query("select s from Student s where s.name=?1")
    //	List<Student> findByName(String name);
    //	List<Student> findByMarks(int marks);

    List<Student> findByMarksGreaterThan(int marks);
}
