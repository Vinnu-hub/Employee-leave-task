package com.example.Employee_Leave_Table.service;

import com.example.Employee_Leave_Table.dto.EmployeeSummaryDTO;
import com.example.Employee_Leave_Table.dto.LeaveSummaryDTO;
import com.example.Employee_Leave_Table.entity.EmpLeave;
import com.example.Employee_Leave_Table.entity.Employee;
import com.example.Employee_Leave_Table.entity.Leave;
import com.example.Employee_Leave_Table.repository.EmpLeaveRepository;
import com.example.Employee_Leave_Table.repository.EmployeeRepository;
import com.example.Employee_Leave_Table.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeLeaveService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmpLeaveRepository empLeaveRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    // Get leave summary by employeeId
    public EmployeeSummaryDTO getLeaveSummary(Long empId) {
        // Fetch the employee from the database
        Optional<Employee> employeeOpt = employeeRepository.findById(empId);
        if (!employeeOpt.isPresent()) {
            throw new RuntimeException("Employee not found with id: " + empId);
        }
        Employee employee = employeeOpt.get();

        // For now, set total leaves eligible to a fixed value (can be dynamic based on your system)
        int totalLeavesEligible = 20;

        // Initialize the variables for calculating leaves
        Map<String, Integer> leavesTakenMap = new HashMap<>();
        int totalLeavesTaken = 0;

        // Fetch all the EmpLeave records for the employee
        List<EmpLeave> empLeaves = empLeaveRepository.findByEmployeeEmpId(empId);

        // Iterate over each EmpLeave record
        for (EmpLeave empLeave : empLeaves) {
            Leave leave = empLeave.getLeave();
            String leaveType = leave.getLeaveType();  // Get the leave type (e.g., Sick, Casual)

            // Update the leave count for this type
            leavesTakenMap.put(leaveType, leavesTakenMap.getOrDefault(leaveType, 0) + 1);
            totalLeavesTaken += 1;  // Increment total leaves taken by 1 for each record
        }

        // Calculate the balance leaves
        int balanceLeaves = totalLeavesEligible - totalLeavesTaken;

        // Calculate excess leaves if the total leaves taken exceeds the eligible ones
        int excessLeaves = 0;
        if (totalLeavesTaken > totalLeavesEligible) {
            excessLeaves = totalLeavesTaken - totalLeavesEligible;
        }

        // Prepare the EmployeeSummaryDTO to return the summary
        EmployeeSummaryDTO employeeSummaryDTO = new EmployeeSummaryDTO();
        employeeSummaryDTO.setEmpId(employee.getEmpId());
        employeeSummaryDTO.setEmpName(employee.getName());
        employeeSummaryDTO.setTotalLeavesEligible(totalLeavesEligible);
        employeeSummaryDTO.setLeavesTaken(totalLeavesTaken);
        employeeSummaryDTO.setBalanceLeaves(balanceLeaves);
        employeeSummaryDTO.setExcessLeaves(excessLeaves);

        // Add leave summaries for each leave type (Sick, Vacation, Casual, etc.)
        for (Map.Entry<String, Integer> entry : leavesTakenMap.entrySet()) {
            LeaveSummaryDTO leaveSummaryDTO = new LeaveSummaryDTO(entry.getKey(), entry.getValue());
            employeeSummaryDTO.addLeaveSummary(leaveSummaryDTO);
        }

        return employeeSummaryDTO;
    }
}
