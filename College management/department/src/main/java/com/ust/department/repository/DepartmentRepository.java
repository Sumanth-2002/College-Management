package com.ust.department.repository;

import com.ust.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    List<Department> findDepartmentBycollegeId(Long collegeId);
}
