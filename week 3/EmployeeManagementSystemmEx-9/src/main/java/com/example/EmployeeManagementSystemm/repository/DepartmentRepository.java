package com.example.EmployeeManagementSystemm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.EmployeeManagementSystemm.entity.Department;
import com.example.EmployeeManagementSystemm.projection.DepartmentProjection;
import java.util.List;



@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query("SELECT d FROM Department d")
    List<DepartmentProjection> findAllDepartments();

    //Named Query
    @Query(name="Department.findByName")
    DepartmentProjection findDepartmentByName(@Param("name") String name);

    //Custom Query
    @Query("SELECT d FROM Department d WHERE d.id=:id")
    DepartmentProjection findDepartmentById(Long id);
}



