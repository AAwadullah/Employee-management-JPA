package com.pwc.tassignment.company.repositories;

import com.pwc.tassignment.company.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {

    Employee findEmployeeByEmail(String email);
    Employee findEmployeeByName(String name);
    void deleteByEmail(String email);
}
