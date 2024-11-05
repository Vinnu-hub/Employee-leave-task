package com.example.Employee_Leave_Table.service;

import com.example.Employee_Leave_Table.entity.EmpLeave;
import com.example.Employee_Leave_Table.repository.EmpLeaveRepository;
import com.example.Employee_Leave_Table.entity.Employee;
import com.example.Employee_Leave_Table.entity.Leave;
import com.example.Employee_Leave_Table.repository.EmployeeRepository;
import com.example.Employee_Leave_Table.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpLeaveService {

    @Autowired
    private EmpLeaveRepository empLeaveRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    // Method to add an employee leave record (empId and leaveId are passed manually)
    public EmpLeave addEmpLeave(Long empId, Long leaveId, EmpLeave empLeave) {
        // Fetch the employee from the Employee table
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));

        // Fetch the leave from the Leave table
        Leave leave = leaveRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave type not found with id: " + leaveId));

        // Set the employee and leave for the EmpLeave entity
        empLeave.setEmployee(employee);
        empLeave.setLeave(leave);

        // Save the EmpLeave entity
        return empLeaveRepository.save(empLeave);
    }
}
