package com.example.demo.service.Student;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entities.Student;
import com.example.demo.rểpository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public int save(StudentDTO studentDTO) {
        try{
            studentRepository.save(studentDTO.toEntity());
            return 1;
        }catch (Exception e){
            return  0 ;
        }

    }

    @Override
    public List<Student> search(String name) {

        return studentRepository.findByName(name);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public int deleteById(Long id) {
        try{
            studentRepository.deleteById(id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
}
