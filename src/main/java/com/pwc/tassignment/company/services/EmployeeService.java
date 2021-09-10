package com.pwc.tassignment.company.services;

import com.pwc.tassignment.company.entities.Department;
import com.pwc.tassignment.company.entities.Employee;
import com.pwc.tassignment.company.repositories.DepartmentRepository;
import com.pwc.tassignment.company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee create(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    public Employee findEmployeeByName(String email) {
        return employeeRepository.findEmployeeByName(email);
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employeeRepository.findAll());
    }

    public Employee update(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteByEmail(String email){
        employeeRepository.deleteByEmail(email);
    }

    public void deleteById(Long empId){
        employeeRepository.deleteById(empId);
    }

    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortBy) {
        Sort sort = Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return employeeRepository.findAll(pageable);
    }

    public Employee findById(Long empId){
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }else
        {
            throw new RuntimeException("Employee with Id is not found.");
        }
    }


    public Set<Employee> selectByDeptId(Integer id) {
        Optional<Department> optDept = departmentRepository.findById(id);
        if (optDept.isPresent()) {
            return optDept.get().getDepartmentEmployees();
        } else {
            return new HashSet<>();
        }
    }





}
