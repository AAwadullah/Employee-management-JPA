package com.pwc.tassignment.company.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeID;

    @Column
    private String name;
    @Column(nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    private EmpRole empRole;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", nullable = false, updatable = true)
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "projects_works_on",
            joinColumns = @JoinColumn(name = "project_Id"),
            inverseJoinColumns = @JoinColumn(name = "employeeID")
    )
    private Set<Project> projectsWorkingOn = new HashSet<>();

    public Employee() {

    }

    public Employee(String name, String email, EmpRole empRole, Department department) {
        this.name = name;
        this.email = email;
        this.empRole = empRole;
        this.department = department;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmpRole getEmpRole() {
        return empRole;
    }

    public void setEmpRole(EmpRole role) {
        this.empRole = role;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
