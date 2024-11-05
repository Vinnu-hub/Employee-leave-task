package com.example.Employee_Leave_Table.controller;

import com.example.Employee_Leave_Table.entity.Employee;
import com.example.Employee_Leave_Table.entity.Leave;
import com.example.Employee_Leave_Table.entity.EmpLeave;
import com.example.Employee_Leave_Table.service.EmployeeService;
import com.example.Employee_Leave_Table.service.LeaveService;
import com.example.Employee_Leave_Table.service.EmpLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add")
public class EmployeeLeaveAddController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private EmpLeaveService empLeaveService;

    // Endpoint to add an employee (you pass the empId manually)
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Endpoint to add a leave type
    @PostMapping("/leave")
    public ResponseEntity<Leave> addLeave(@RequestBody Leave leave) {
        Leave savedLeave = leaveService.addLeave(leave);
        return new ResponseEntity<>(savedLeave, HttpStatus.CREATED);
    }

    @PostMapping("/emp-leave")
    public ResponseEntity<EmpLeave> addEmpLeave(@RequestParam Long empId, @RequestParam Long leaveId, @RequestBody EmpLeave empLeave) {
        try {
            EmpLeave savedEmpLeave = empLeaveService.addEmpLeave(empId, leaveId, empLeave);
            return new ResponseEntity<>(savedEmpLeave, HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);  // Handle errors like "Employee not found" or "Leave not found"
        }
    }
}
