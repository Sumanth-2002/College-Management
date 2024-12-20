package com.ust.college.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;



public class Departmentdto{

    private  Long deptId;
    private String name;
    private String Strength;
    private String Hod;

    public Departmentdto() {
    }

    private Long collegeId;

    public Departmentdto(Long deptId, String name, String strength, String hod, Long collegeId, String deptWebsite,List<Studentdto> studentdtoList) {
        this.deptId = deptId;
        this.name = name;
        Strength = strength;
        Hod = hod;
        this.collegeId = collegeId;
        this.deptWebsite = deptWebsite;
        this.studentdtoList = studentdtoList;
    }

    private String deptWebsite;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrength() {
        return Strength;
    }

    public void setStrength(String strength) {
        Strength = strength;
    }

    public List<Studentdto> getStudentdtoList() {
        return studentdtoList;
    }

    public void setStudentdtoList(List<Studentdto> studentdtoList) {
        this.studentdtoList = studentdtoList;
    }

    public String getHod() {
        return Hod;
    }

    public void setHod(String hod) {
        Hod = hod;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getDeptWebsite() {
        return deptWebsite;
    }

    public void setDeptWebsite(String deptWebsite) {
        this.deptWebsite = deptWebsite;
    }
    public List<Studentdto> studentdtoList;
}