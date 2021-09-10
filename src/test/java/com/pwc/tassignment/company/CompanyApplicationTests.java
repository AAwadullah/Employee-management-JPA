package com.pwc.tassignment.company;

import com.pwc.tassignment.company.entities.Employee;
import com.pwc.tassignment.company.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CompanyApplicationTests {

    @Autowired
    EmployeeService employeeService;

    @Test
    void contextLoads() {
    }






}
