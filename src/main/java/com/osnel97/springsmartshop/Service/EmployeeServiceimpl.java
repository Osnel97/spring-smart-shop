package com.osnel97.springsmartshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.osnel97.springsmartshop.Repository.EmployeeRepository;
import com.osnel97.springsmartshop.model.Employee;

@Service
public class EmployeeServiceimpl implements  EmployeeService {
    private final EmployeeRepository employeeRepository;

@Autowired
public EmployeeServiceimpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

@Override
public Employee  addEmployee(Employee employee){
    return employeeRepository.save(employee);
}

@Override
public List<Employee> findAllEmployees(){
    return employeeRepository.findAll();
}

@Override
public Optional<Employee> findById(long id) {
    return employeeRepository.findById(id);
}

@Override
public Optional<Employee> findByEmail(String email) {
    return employeeRepository.findByEmail(email);
}
@Override
public Employee updateEmployee(long id, Employee employee){
    employee.setId(id);
    return employeeRepository.save(employee);
}

@Override
public void deleteEmployee(long id) {
    employeeRepository.deleteById(id);
}

}
