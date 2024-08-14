package com.example.EmployeeManagementSystemm.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    @Value("#{target.id}")
    long getId();
    @Value("#{target.name}")
    String getName();
    @Value("#{target.email}")
    String getEmail();
    @Value("#{target.department.name}")
    String getDepartmentName();
}
