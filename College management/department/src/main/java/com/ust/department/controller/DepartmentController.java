package com.ust.department.controller;


import com.ust.department.dto.Responsedto;
import com.ust.department.entity.Department;
import com.ust.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @GetMapping("/getDeptByCollegeId/{collegeId}")
    public List<Department> getDeptByCollegeId(@PathVariable Long collegeId) {
        return departmentService.getDepartmentByCollegeId(collegeId);
    }

    @GetMapping("/getStudentByDeptID/{deptId}")
    public Responsedto getStudent(@PathVariable("deptId") Long deptId) {
        Responsedto responsedto = departmentService.getStudent(deptId);
        return responsedto;

    }
}