package com.example.demo.Resource;


import com.example.demo.dto.StudentDTO;
import com.example.demo.entities.Student;
import com.example.demo.rểpository.StudentRepository;
import com.example.demo.service.Student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRest  {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>>getAll(){
        List<Student> studentList = iStudentService.getAll();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody StudentDTO studentDTO){
        int result = iStudentService.save(studentDTO);
        if(result == 1){
            return new ResponseEntity<>("them moi thanh cong" , HttpStatus.OK);
        }else {
            return new ResponseEntity<>("khong thanh congq" , HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping("/search")
    public ResponseEntity<List<Student>> search(@RequestParam("txt_search") String text ){
        List<Student> studentList = new ArrayList<>();
        if(text == ""){
            studentList = iStudentService.getAll();
        }else {
            studentList = iStudentService.search(text);
        }


        return new ResponseEntity<>(studentList,HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id ,@RequestBody StudentDTO studentDTO ){
        studentRepository.save(new Student(id,studentDTO.getName(),studentDTO.getAge()));
        return new ResponseEntity<>("them moi thanh cong" , HttpStatus.OK);
    }
/*    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        try{
            int resule = studentRepository.deleteById(id);
            resule
        }
        return new ResponseEntity<>("đã xóa" , HttpStatus.OK);
    }*/
}
