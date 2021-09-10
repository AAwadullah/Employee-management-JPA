package com.pwc.tassignment.company.services;


import com.pwc.tassignment.company.entities.Department;
import com.pwc.tassignment.company.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department findByName(String name){
        return departmentRepository.findByName(name);
    }

    public Department create(Department department){
        return departmentRepository.saveAndFlush(department);
    }

    public Department update(Department department){
        return departmentRepository.save(department);
    }


    public void deleteById(Integer department){
         departmentRepository.deleteById(department);
    }

    public Department findById(Integer depID){
        Optional<Department> optDep = departmentRepository.findById(depID);
        if (optDep.isPresent()) {
            return optDep.get();
        } else {
            throw new RuntimeException("Dept id not found, ID = " + depID);
        }
    }
}
