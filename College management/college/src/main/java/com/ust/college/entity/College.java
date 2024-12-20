package com.ust.college.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class College {
    @Id
    private Long collegeId;
    private String name;
    private String founder;

    public College() {
    }

    public College(Long collegeId, String name, String founder, String location, String strength) {
        this.collegeId = collegeId;
        this.name = name;
        this.founder = founder;
        this.location = location;
        this.strength = strength;
    }

    private String location;
    private String strength;

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
