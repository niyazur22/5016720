package com.example.EmployeeManagementSystemm.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
        @NamedQuery(name = "Employee.findByDepartmentName", query = "SELECT e FROM Employee e JOIN e.department d WHERE d.name = :departmentName")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and Setters
}


