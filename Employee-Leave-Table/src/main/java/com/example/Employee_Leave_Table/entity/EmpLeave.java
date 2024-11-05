package com.example.Employee_Leave_Table.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmpLeave {

    @Id
    private Long id;

    // Many EmpLeave records belong to one employee
    @ManyToOne
    @JoinColumn(name = "emp_id")  // Foreign key for Employee
    private Employee employee;

    // Many EmpLeave records belong to one leave type
    @ManyToOne
    @JoinColumn(name = "leave_id")  // Foreign key for Leave
    private Leave leave;

    private LocalDate date;
}
