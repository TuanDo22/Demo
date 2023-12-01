package com.example.demo.service.Employee;

import com.example.demo.Model.EmployeeModel;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entities.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.rểpository.AddressRepository;
import com.example.demo.rểpository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<EmployeeDTO> getAll() {
        List<EmployeeDTO> employeeDTOS = employeeRepository.findAll().stream().map(e->employeeMapper.toDTO(e)).toList();
        return employeeDTOS ;
    }

    @Override
    public void save(EmployeeModel employeeModel) {
        Employee employee = new Employee();
        employee.setName(employeeModel.getName());
        employee.setAge(employeeModel.getAge());
        employee.setAddress(addressRepository.findById(employeeModel.getAddress_id()).get());
        employeeRepository.save(employee);
    }

    @Override
    public void update(EmployeeModel employeeModel) {
        Employee employee = new Employee();
        employee.setId(employee.getId());
        employee.setName(employeeModel.getName());
        employee.setAge(employeeModel.getAge());
        employee.setAddress(addressRepository.findById(employeeModel.getAddress_id()).get());
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
         employeeRepository.deleteById(id);
    };

}
