package com.example.Employee_Leave_Table.repository;

import com.example.Employee_Leave_Table.entity.EmpLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpLeaveRepository extends JpaRepository<EmpLeave, Long> {

    List<EmpLeave> findByEmployeeEmpId(Long empId);
}
