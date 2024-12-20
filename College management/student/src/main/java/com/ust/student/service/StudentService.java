package com.ust.student.service;

import com.ust.student.entity.Student;
import com.ust.student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findStudentByDepartmentId(Long deptId){
        return studentRepository.findStudentBydeptId(deptId);

    }

    public Student findStudentById(Long id){
        return  studentRepository.findById(id).orElse(null);
    }

}
