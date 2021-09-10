package com.pwc.tassignment.company.pojos;

import com.pwc.tassignment.company.entities.EmpRole;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class EmployeePojo {


    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private EmpRole empRole;
    private Long mangerID;
    private Integer departmentID;

    public EmployeePojo(String name, String email, EmpRole empRole, Long mangerID, Integer departmentID) {
        this.name = name;
        this.email = email;
        this.empRole = empRole;
        this.mangerID = mangerID;
        this.departmentID = departmentID;
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

    public EmpRole getRole() {
        return empRole;
    }

    public void setRole(EmpRole empRole) {
        this.empRole = empRole;
    }

    public Long getMangerID() {
        return mangerID;
    }

    public void setMangerID(Long mangerID) {
        this.mangerID = mangerID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }
}
