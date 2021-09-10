package com.pwc.tassignment.company.entities;


import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Department {

    public Department() {

    }

    public Department(Integer departmentID, String name) {
        this.departmentID = departmentID;
        this.name = name;
    }

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Integer departmentID;

    @Column
    private String name;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Employee> departmentEmployees = new HashSet<>();

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(Set<Employee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }

    public void addEmployee(Employee employee){
        this.departmentEmployees.add(employee);
    }

    public boolean removeEmployee(Employee employee){
        return this.departmentEmployees.remove(employee);
    }




}
