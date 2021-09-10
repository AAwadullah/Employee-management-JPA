package com.pwc.tassignment.company.entities;


import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project {

    public Project() {

    }

    public Project(Long projectID, String name) {
        this.projectID = projectID;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long projectID;

    @Column
    private String name;


    @ManyToMany(mappedBy = "projectsWorkingOn")
    @JsonIgnore
    private Set<Employee> projectEmployees = new HashSet<>();


    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getProjectEmployees() {
        return projectEmployees;
    }

    public void setProjectEmployees(Set<Employee> projectEmployees) {
        this.projectEmployees = projectEmployees;
    }

    public void addEmployee(Employee employee) {
        this.projectEmployees.add(employee);
    }
    public boolean removeEmployee(Employee employee) {
        return this.projectEmployees.add(employee);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectID +
                ", name='" + name + '\'' +
                ", projectEmployees=" + projectEmployees +
                '}';
    }
}
