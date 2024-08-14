package com.example.EmployeeManagementSystemm.repository;
import com.example.EmployeeManagementSystemm.projection.EmpNameEmail;
import com.example.EmployeeManagementSystemm.projection.EmpDetails;
import com.example.EmployeeManagementSystemm.entity.Employee;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    List<Employee> findByDepartmentId(Long departmentID);

    //Custom queries
    @Query(name="Employee.findByEmail")
    List<EmployeeProjection> findByEmail(@Param("email") String email);
    @Query(name="Employee.findByName")
    List<EmployeeProjection> findByName(@Param("name") String name);


    @Query("SELECT e FROM Employee e WHERE e.id=:id")
    EmployeeProjection findEmpById(Long id);

    //Adding Pageable
    @SuppressWarnings("null")
    @Query("SELECT new com.employeemanagementsystem.dto.EmployeeDTO(e.id,e.name,e.email,e.department.name) FROM Employee e")
    Page<Employee> findAll(Pageable pageable);
}
