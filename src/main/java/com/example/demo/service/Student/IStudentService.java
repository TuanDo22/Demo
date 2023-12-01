package com.example.demo.service.Student;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entities.Student;
import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    int save(StudentDTO studentDTO);
    List<Student> search(String txt);
    Student findById(Long id);
    int deleteById(Long id);

}
