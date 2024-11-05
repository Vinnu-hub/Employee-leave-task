package com.example.Employee_Leave_Table.repository;

import com.example.Employee_Leave_Table.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
