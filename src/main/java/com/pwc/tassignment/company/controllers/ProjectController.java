package com.pwc.tassignment.company.controllers;

import com.pwc.tassignment.company.entities.Employee;
import com.pwc.tassignment.company.entities.Project;
import com.pwc.tassignment.company.services.EmployeeService;
import com.pwc.tassignment.company.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/project/createNewDepartment")
    public Project create(@RequestBody Project project) {
        return projectService.create(project);
    }


    @PostMapping("/project/update")
    public Project update(@RequestBody Project project) {
        return projectService.update(project);
    }

    @GetMapping("/project/getById.{projId}")
    public Project getProjectById(@PathVariable Long projId) {
        return projectService.findProjectById(projId);
    }

    @GetMapping("/project/getAll")
    public List<Project> getAllProjects() {
        return projectService.findAllProjects();
    }


    @DeleteMapping("/project/deleteById.{projId}")
    public String deleteDept(@PathVariable Long projId) {
        projectService.deleteById(projId);
        return "department"+ projId +" deleted Successfully ";
    }


    @PutMapping("/project/assignProjToEmp.{projectId}.emp.{employeeID}/")
    public Project assignProjectToEmployee(@PathVariable Long projectId,
                                           @PathVariable Long employeeID) {
        Employee employee = employeeService.findById(employeeID);
        Project project = projectService.findProjectById(projectId);
        project.addEmployee(employee);
        return projectService.update(project);
    }

    @PutMapping("/project/removeEmpFromProj.{projectId}.emp.{employeeID}/")
    public Project removeProjectToEmployee(@PathVariable Long projectId,
                                           @PathVariable Long employeeID) {
        Employee employee = employeeService.findById(employeeID);
        Project project = projectService.findProjectById(projectId);
        project.removeEmployee(employee);
        return projectService.update(project);
    }

}
