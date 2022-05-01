package com.edu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.demo.entity.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
