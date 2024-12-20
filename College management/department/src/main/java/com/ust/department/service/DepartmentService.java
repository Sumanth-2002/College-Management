package com.ust.department.service;

import com.ust.department.dto.Departmentdto;
import com.ust.department.dto.Responsedto;
import com.ust.department.dto.Studentdto;
import com.ust.department.entity.Department;
import com.ust.department.repository.DepartmentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private WebClient webClient;

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }
    public Department getDepartmentById(Long deptId){
        return departmentRepository.findById(deptId).orElse(null);
    }

    public List<Department> getDepartmentByCollegeId(Long collegeId){
        return departmentRepository.findDepartmentBycollegeId(collegeId);
    }


    @CircuitBreaker(name = "departmentService", fallbackMethod = "fallbackGetDepartment")
    public Responsedto getStudent(Long deptId) {
        Responsedto responseDto = new Responsedto();
        Department department = departmentRepository.findById(deptId).orElseThrow(() -> new RuntimeException("Department not found"));
        Departmentdto departmentdto = mapToDepartmentdto(department);

        List<Studentdto> studentdtoList = webClient.get()
                .uri("http://localhost:9097/student/getStudentByDeptId/" + department.getDeptId())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Studentdto>>() {})
                .block();

        responseDto.setDepartmentdto(departmentdto);
        responseDto.setStudentdto(studentdtoList);

        return responseDto;
    }

    public Responsedto fallbackGetDepartment(Long deptId, Throwable throwable) {
        // Handle the fallback logic, e.g., return a default response or log the error
        return new Responsedto(); // Return an empty response or a default response
    }

    private Departmentdto mapToDepartmentdto(Department department) {
        Departmentdto departmentdto = new Departmentdto();
       departmentdto.setDeptId(department.getDeptId());
       departmentdto.setCollegeId(department.getCollegeId());
       departmentdto.setHod(department.getHod());
       departmentdto.setName(department.getName());
       departmentdto.setStrength(department.getStrength());
        return departmentdto;
    }
}
