package com.pwc.tassignment.company.controllers;

import com.pwc.tassignment.company.entities.Department;
import com.pwc.tassignment.company.entities.Employee;
import com.pwc.tassignment.company.services.DepartmentService;
import com.pwc.tassignment.company.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/dept/createNewDepartment")
    public Department create(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @DeleteMapping("/dept/deleteById.{deptID}")
    public String deleteDept(@PathVariable Integer deptID) {
        departmentService.deleteById(deptID);
        return "department"+ deptID +" deleted Successfully ";
    }


    @PostMapping("/dept/updateDept.{deptId}")
    public Department update(@RequestBody Department department) {
        return departmentService.create(department);
    }


    @PutMapping("/dept/assignEmpToDept.{deptID}.emp.{employeeID}/")
    public Department assignEmployeeToDept(@PathVariable Integer deptID,
                                           @PathVariable Long employeeID) {
        Employee employee = employeeService.findById(employeeID);
        Department department = departmentService.findById(deptID);
        department.addEmployee(employee);
        return departmentService.update(department);
    }


    @PutMapping("/dept/removeEmpFromDept.{deptID}.emp.{employeeID}/")
    public Department removeEmployeeFromDept(@PathVariable Integer deptID,
                                           @PathVariable Long employeeID) {
        Employee employee = employeeService.findById(employeeID);
        Department department = departmentService.findById(deptID);
        department.removeEmployee(employee);
        return departmentService.update(department);
    }

}
