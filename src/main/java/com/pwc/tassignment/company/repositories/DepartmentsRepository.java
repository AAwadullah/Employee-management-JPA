package com.pwc.tassignment.company.repositories;

import com.pwc.tassignment.company.entities.Department;
import com.pwc.tassignment.company.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentsRepository extends JpaRepository<Department,Integer> {

    Department findByName(String name);




}
