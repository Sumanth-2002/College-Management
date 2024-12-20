package com.ust.student.controller;

import com.ust.student.entity.Student;
import com.ust.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
       return  studentService.addStudent(student);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }


    @GetMapping("/getStudentByDeptId/{deptId}")
    public List<Student> getStudentByDepartmentId(@PathVariable Long deptId){
        return studentService.findStudentByDepartmentId(deptId);
    }

}
