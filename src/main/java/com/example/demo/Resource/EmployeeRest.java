package com.example.demo.Resource;

import com.example.demo.Model.EmployeeModel;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entities.Employee;
import com.example.demo.rểpository.EmployeeRepository;
import com.example.demo.service.Employee.EmployeeService;
import com.example.demo.service.Employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeRest {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDTO>> getAll(){
        List<EmployeeDTO> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody EmployeeModel employeeModel){
        employeeService.save(employeeModel);
            return new ResponseEntity<>("okiee", HttpStatus.OK);

    }
    @PutMapping("/update")
    public ResponseEntity<String> update( @RequestBody EmployeeModel employeeModel ){
        // em để ở đây là hàm save . nó k hợp lý vì save thì k cần id . còn update thì cần id .đúng k ???
        //đúng em . ở phần nay thì sẽ truyển ở trong body về đầy đủ gồm cả id . kiểu submit 1 cái form ấy em
        //cái put này có đặc điểm khác. trong buổi tới thầy sẽ thực hành và nói lại nhé

        //hiện tại thì project mang tính chất demo nên em chưa hiểu . sắp tới khóa kia sẽ làm đầy đủ project thầy sẽ cho e thấy
        //hiện tại em chỉ cần hiểu là nó sinh ra để linh hoạt cách nhận về


        employeeService.update(employeeModel);
        //ở đây emd đang sử dụng contructer 3 tham số , nhưng ở bên employee thì k có


        return new ResponseEntity<>("update thanh cong" , HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id ){
        employeeService.delete(id);
        return new ResponseEntity<>("Xoa thanh cong" , HttpStatus.OK);
    }

 }
