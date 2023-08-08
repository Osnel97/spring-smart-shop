package com.osnel97.springsmartshop.Service;

import java.util.List;
import java.util.Optional;

import com.osnel97.springsmartshop.model.Employee;

public interface EmployeeService {
    Employee  addEmployee(Employee employee);
    List<Employee> findAllEmployees();
    Optional<Employee> findById(long id);
    Optional<Employee> findByEmail(String email);
    Employee updateEmployee(long id, Employee employee);
    void deleteEmployee(long id);

}
