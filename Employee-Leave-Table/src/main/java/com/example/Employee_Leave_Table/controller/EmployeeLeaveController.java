package com.example.Employee_Leave_Table.controller;

import com.example.Employee_Leave_Table.dto.EmployeeSummaryDTO;
import com.example.Employee_Leave_Table.service.EmployeeLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeLeaveController {

    @Autowired
    private EmployeeLeaveService employeeLeaveService;

    // Get leave summary for an employee by ID
    @GetMapping("/employee/leave-summary/{empId}")
    public EmployeeSummaryDTO getLeaveSummary(@PathVariable Long empId) {
        return employeeLeaveService.getLeaveSummary(empId);
    }
}
