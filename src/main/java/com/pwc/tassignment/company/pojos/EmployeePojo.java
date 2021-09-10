package com.pwc.tassignment.company.pojos;

import com.pwc.tassignment.company.entities.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class EmployeePojo {


    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Long mangerID;
    private Integer departmentID;

    public EmployeePojo(String name, String email, Role role, Long mangerID, Integer departmentID) {
        this.name = name;
        this.email = email;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
