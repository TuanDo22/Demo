package com.example.demo.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class EmployeeModel {
    private long id;
    private String name;
    private int age ;
    private long address_id;
}
