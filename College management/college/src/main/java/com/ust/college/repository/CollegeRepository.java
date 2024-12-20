package com.ust.college.repository;

import com.ust.college.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Long> {
}
