package com.example.EmployeeManagementSystemm.repository;

import com.example.EmployeeManagementSystemm.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}


