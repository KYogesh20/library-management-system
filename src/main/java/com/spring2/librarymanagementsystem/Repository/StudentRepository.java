package com.spring2.librarymanagementsystem.Repository;

import com.spring2.librarymanagementsystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);
    List<Student> findByAge(int age);
}
