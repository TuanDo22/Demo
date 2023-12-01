package com.example.demo.dto;

import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class EmployeeDTO {
    private long id;
    private String name ;
    private int age;
    private AddressDTO list_address;

}
