package com.example.Employee_Leave_Table.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leave_type") // Change table name to avoid reserved word 'leave'
public class Leave {

    @Id
    private Long id;

    private String leaveType;  // Changed field name to follow camelCase convention

    private String description;

    // One leave can be associated with many employees (One-to-Many relationship)
    @OneToMany(mappedBy = "leave")  // Corrected mappedBy to refer to 'leave' in EmpLeave
    private List<EmpLeave> empLeaves;
}
