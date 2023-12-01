package com.example.demo.mapper;

import com.example.demo.Model.EmployeeModel;
import com.example.demo.dto.AddressDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entities.Address;
import com.example.demo.entities.Employee;
import com.example.demo.rểpository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    @Autowired
    private AddressRepository addressRepository;
    public EmployeeDTO toDTO(Employee employee){
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .age(employee.getAge())
                .list_address(new AddressDTO(
                                employee.getAddress().getId(),
                                employee.getAddress().getName(),
                                employee.getAddress().getCode()))
                .build();
    }


}
