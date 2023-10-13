package com.EmployeManagement.Demo.controller;

import com.EmployeManagement.Demo.model.Employee;
import com.EmployeManagement.Demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
@Autowired
    private EmployeeService employeeService;
// add employee
@PostMapping("/addEmp")
    public Employee addEmployee(@RequestBody Employee employee){
       return employeeService.addEmployee(employee);
    }
    // add more than one employee
    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return employeeService.addAllEmployees(employees);
    }
    // get employee by id
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable int id){
    return employeeService.getEmployeeByID(id);
    }
    // update employee
    @PutMapping("/updateEmployee")
    public  Employee updateEmployee(@RequestBody Employee employee){
    return employeeService.updateEmmployee(employee);
    }

    // delete employee
    @DeleteMapping("/deleteEmployee/{id}")
    public boolean deleteEmployee(@PathVariable int id){
     return  employeeService.deleteEmployeebyID(id);
    }
}
