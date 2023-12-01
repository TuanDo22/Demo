package com.example.demo.rểpository;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findByName(String name);

}
