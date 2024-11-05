package com.example.Employee_Leave_Table.repository;

import com.example.Employee_Leave_Table.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave,Long> {
}


