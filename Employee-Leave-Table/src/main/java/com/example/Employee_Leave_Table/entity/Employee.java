package com.example.Employee_Leave_Table.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long empId;

    private String name;

    // One employee can have many leave records (One-to-Many relationship)
    @OneToMany(mappedBy = "employee")
    private List<EmpLeave> empLeaves;
}
