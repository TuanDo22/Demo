package com.example.demo.dto;

import com.example.demo.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {
    private String name;
    private int age;

    public Student toEntity(){
        return  new Student(0L,this.name,this.age);
    }
}
