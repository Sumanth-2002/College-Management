package com.ust.college.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responsedto {
    public Responsedto() {
    }

    private Collegedto collegedto;
    private List<Departmentdto> departmentdtoList;

    public Responsedto(Collegedto collegedto, List<Departmentdto> departmentdtoList) {
        this.collegedto = collegedto;
        this.departmentdtoList = departmentdtoList;
    }

    public Collegedto getCollegedto() {
        return collegedto;
    }

    public void setCollegedto(Collegedto collegedto) {
        this.collegedto = collegedto;
    }

    public List<Departmentdto> getDepartmentdtoList() {
        return departmentdtoList;
    }

    public void setDepartmentdtoList(List<Departmentdto> departmentdtoList) {
        this.departmentdtoList = departmentdtoList;
    }
}