package com.ust.department.dto;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class Departmentdto{
    @Id
    private  Long deptId;
    private String name;
    private String Strength;
    private String Hod;

    public Departmentdto() {
    }

    private Long collegeId;

    public Departmentdto(Long deptId, String name, String strength, String hod, Long collegeId, String deptWebsite) {
        this.deptId = deptId;
        this.name = name;
        Strength = strength;
        Hod = hod;
        this.collegeId = collegeId;
        this.deptWebsite = deptWebsite;
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
}