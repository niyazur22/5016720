package com.example.EmployeeManagementSystemm.repository;

import com.example.EmployeeManagementSystemm.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

