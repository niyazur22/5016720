package com.example.EmployeeManagementSystemm.repository;

import com.example.EmployeeManagementSystemm.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Execute named query defined in Employee entity
    List<Employee> findByFirstName(@Param("firstName") String firstName);

    // Execute named query defined in Employee entity
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);
}




