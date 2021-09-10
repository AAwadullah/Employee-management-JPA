package com.pwc.tassignment.company.services;


import com.pwc.tassignment.company.entities.Department;
import com.pwc.tassignment.company.repositories.DepartmentsRepository;
import com.pwc.tassignment.company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentsRepository departmentsRepository;

    public List<Department> findAllDepartments(){
        return departmentsRepository.findAll();
    }

    public Department findByName(String name){
        return departmentsRepository.findByName(name);
    }

    public Department create(Department department){
        return departmentsRepository.saveAndFlush(department);
    }

    public Department update(Department department){
        return departmentsRepository.save(department);
    }


    public void deleteById(Integer department){
         departmentsRepository.deleteById(department);
    }

    public Department findById(Integer depID){
        Optional<Department> optDep = departmentsRepository.findById(depID);
        if (optDep.isPresent()) {
            return optDep.get();
        } else {
            throw new RuntimeException("Dept id not found, ID = " + depID);
        }
    }
}
