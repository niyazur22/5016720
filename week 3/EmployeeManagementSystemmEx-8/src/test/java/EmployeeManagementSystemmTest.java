package com.example.EmployeeManagementSystemm.;

import com.example.EmployeeManagementSystemm.model.Employee;
import com.example.EmployeeManagementSystemm.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindByFirstName() {
        List<Employee> employees = employeeRepository.findByFirstName("John");
        employees.forEach(System.out::println);
    }

    @Test
    public void testFindEmployeesByDepartmentName() {
        List<Employee> employees = employeeRepository.findByDepartmentName("HR");
        employees.forEach(System.out::println);
    }

    @Test
    public void testFindEmployeesByEmailDomain() {
        List<Employee> employees = employeeRepository.findEmployeesByEmailDomain("@example.com");
        employees.forEach(System.out::println);
    }
}
