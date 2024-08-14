package com.example.EmployeeManagementSystemm;

import com.example.EmployeeManagementSystemm.repository.DepartmentRepository;
import com.example.EmployeeManagementSystemm.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeManagementSystemTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    @Test
    public void testSaveEntities() {
        Department department = new Department();
        department.setName("IT");

        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
        employee.setDepartment(department);

        departmentRepository.save(department);
        employeeRepository.save(employee);
    }
}
