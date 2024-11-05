package com.example.Employee_Leave_Table.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeSummaryDTO {

    private Long empId;
    private String empName;
    private int totalLeavesEligible;
    private int leavesTaken;
    private int balanceLeaves;
    private int excessLeaves;

    private List<LeaveSummaryDTO> leaveSummaries = new ArrayList<>();

    public EmployeeSummaryDTO() {

    }

    public void addLeaveSummary(LeaveSummaryDTO leaveSummaryDTO) {
        this.leaveSummaries.add(leaveSummaryDTO);
    }
}
