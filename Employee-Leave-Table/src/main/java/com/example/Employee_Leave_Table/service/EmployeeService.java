package com.example.Employee_Leave_Table.service;

import com.example.Employee_Leave_Table.entity.Employee;
import com.example.Employee_Leave_Table.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to add a new employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
