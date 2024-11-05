package com.example.Employee_Leave_Table.service;

import com.example.Employee_Leave_Table.entity.Leave;
import com.example.Employee_Leave_Table.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    // Method to add a new leave type
    public Leave addLeave(Leave leave) {
        return leaveRepository.save(leave);
    }
}
