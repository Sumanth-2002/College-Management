package com.ust.department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responsedto {
    private Departmentdto departmentdto;
    private List<Studentdto> studentdto;

    public Departmentdto getDepartmentdto() {
        return departmentdto;
    }

    public void setDepartmentdto(Departmentdto departmentdto) {
        this.departmentdto = departmentdto;
    }

    public List<Studentdto> getStudentdto() {
        return studentdto;
    }

    public void setStudentdto(List<Studentdto> studentdto) {
        this.studentdto = studentdto;
    }
}