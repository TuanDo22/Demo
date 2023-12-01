package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name ;
    private int age;
    @ManyToOne
    @JoinColumn(name = "address_id" , nullable = false)
    private  Address address;

    //ở đây có 4 trường thì all argcontructor sẽ yêu cầu 4 trường
}
