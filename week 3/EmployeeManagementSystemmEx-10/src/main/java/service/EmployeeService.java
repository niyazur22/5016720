package com.example.EmployeeManagementSystemm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystemm.dto.DepartmentDTO;
import com.example.EmployeeManagementSystemm.dto.EmployeeDTO;
import com.example.EmployeeManagementSystemm.entity.Department;
import com.example.EmployeeManagementSystemm.entity.Employee;
import com.example.EmployeeManagementSystemm.projection.DepartmentProjection;
import com.example.EmployeeManagementSystemm.repository.DepartmentRepository;
import com.example.EmployeeManagementSystemm.repository.EmployeeRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    // DTO and Projections
    public List<DepartmentProjection> getAllDepartments(){
        return departmentRepository.findAllDepartments();
    }
    public DepartmentProjection getDeptById(Long id){
        return departmentRepository.findDepartmentById(id);
    }
    // Using DTO employee data is shown
    public DepartmentDTO getDepartmentByName(String name){
        DepartmentProjection dp= departmentRepository.findDepartmentByName(name);
        if(dp==null)
            return null;
        List<Employee> employees=employeeRepository.findByDepartmentId(dp.getId());
        List<EmployeeDTO> employeeDTOs=employees.stream().map(e->new EmployeeDTO(e.getId(),e.getName(),null,null)).collect(Collectors.toList());
        return new DepartmentDTO(dp.getId(), dp.getName(), dp.getEmployeeCount(),employeeDTOs);
    }
    // DTO and Projections end

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }
    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
}


