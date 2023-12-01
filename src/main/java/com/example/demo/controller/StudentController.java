package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entities.Student;
import com.example.demo.rểpository.StudentRepository;
import com.example.demo.service.Student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class StudentController {
    @Autowired
    IStudentService iStudentService ;
    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/demo")
    public String getAll(Model model){
        List<Student> studentList = iStudentService.getAll();
        model.addAttribute("student", studentList);
        return "hi";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("OjStudent" , new StudentDTO());
        return "add";
    }
    @PostMapping("add")
    public String add(@ModelAttribute StudentDTO studentDTO){
        System.out.println(studentDTO);
        iStudentService.save(studentDTO);
        return "redirect:/admin/demo";
    }
    @GetMapping("/search")
    public String search(Model model , @RequestParam("txt_search") String txt_search){

        List<Student> studentList = new ArrayList<>();
        if(txt_search == ""){
            studentList = iStudentService.getAll();
        }else {
            studentList = iStudentService.search(txt_search);
        }
        model.addAttribute("student" , studentList );

        return "hi";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model ,@PathVariable("id") Long id ){
        Student student = iStudentService.findById(id);
        model.addAttribute("OjStudent", student );
        System.out.println(id);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Model model,@ModelAttribute Student student){
        System.out.println(student);
        studentRepository.save(student);


        return "redirect:/admin/demo";
    }


}
