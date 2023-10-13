package com.EmployeManagement.Demo.repository;

import com.EmployeManagement.Demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {
}
