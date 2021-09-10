package com.pwc.tassignment.company.controllers;

import com.pwc.tassignment.company.entities.Employee;
import com.pwc.tassignment.company.pojos.EmployeePojo;
import com.pwc.tassignment.company.services.DepartmentService;
import com.pwc.tassignment.company.services.EmployeeService;
import com.pwc.tassignment.company.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProjectService projectService;


    @PostMapping("/employees/createNewEmployee")
    public Employee create(@RequestBody EmployeePojo empPojo) {
        Employee employee = new Employee(
                empPojo.getName(),
                empPojo.getEmail(),
                empPojo.getRole(),
                departmentService.findById(empPojo.getDepartmentID())
        );
        return employeeService.create(employee);
    }


    @GetMapping("/employees/getAll")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(path = "/getByDept", produces = "application/json")
    public Set<Employee> getEmployeesByDept(int deptId) {
        return employeeService.selectByDeptId(deptId);
    }


    @GetMapping(path = "/getPage", produces = "application/json")
    public Page<Employee> getEmployeePage(
            @RequestParam("pageNumber") int pageNumber,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("sortBy") String sortBy) {
        return employeeService.findPaginated(pageNumber, pageSize, sortBy);
    }

    @GetMapping("/employees/name.{employeeName}")
    public Employee getEmployeeByName(@PathVariable String employeeName) {
        return employeeService.findEmployeeByName(employeeName);
    }

    @GetMapping("/employees/email.{employeeEmail}")
    public Employee getEmployeeByEmail(@PathVariable String employeeEmail) {
        return employeeService.findEmployeeByEmail(employeeEmail);
    }


    @PutMapping("/employees/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.update(theEmployee);
    }

    @DeleteMapping("/employees/deletebyEmail.{employeeEmail}")
    public String deleteEmployee(@PathVariable String employeeEmail) {
        Employee employee = employeeService.findEmployeeByEmail(employeeEmail);
        if (employee == null) {
            throw new RuntimeException("Employee email not found - " + employeeEmail);
        }
        employeeService.deleteByEmail(employeeEmail);
        return "Deleted Employee email - " + employeeEmail;
    }


    @DeleteMapping("/employees/deleteByEmail.{employeeID}")
    public String deleteEmployee(@PathVariable Long employeeID) {
        Employee employee = employeeService.findById(employeeID);
        if (employee == null) {
            throw new RuntimeException("Employee Id not found - " + employeeID);
        }
        employeeService.deleteById(employeeID);
        return "Deleted Employee email - " + employeeID;
    }


}
