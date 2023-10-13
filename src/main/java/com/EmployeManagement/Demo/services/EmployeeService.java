package com.EmployeManagement.Demo.services;

import com.EmployeManagement.Demo.model.Employee;
import com.EmployeManagement.Demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> addAllEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }
    public  Employee getEmployeeByID(int id){
        return employeeRepository.findById(id).orElse(null);
    }
    public  Employee updateEmmployee(Employee employee) {
        Employee existingEmp = employeeRepository.findById(employee.getId()).orElse(null);
        if (existingEmp == null) {
            return employeeRepository.save(employee);
        } else {
            employeeRepository.deleteById(existingEmp.getId());
            employeeRepository.save(employee);
        }
        return employee;
    }
    public boolean deleteEmployeebyID(int id){
       Employee existingEmp = employeeRepository.findById(id).orElse(null);
       if (existingEmp != null) {
           employeeRepository.deleteById(id);
           return true;
       }
       return  false;

    }

}
