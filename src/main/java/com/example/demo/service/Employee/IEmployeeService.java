package com.example.demo.service.Employee;

import com.example.demo.Model.EmployeeModel;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<EmployeeDTO> getAll();

    void save(EmployeeModel employeeModel);
    void update(EmployeeModel employeeModel);
    void delete(Long id);
}
