package com.example.Employee_Leave_Table.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LeaveSummaryDTO {

    private String leaveType;  // The leave type name (e.g., Sick, Vacation, Casual)
    private int leaveCount;    // The number of leaves taken for this leave type
}
