package com.osnel97.springsmartshop.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osnel97.springsmartshop.Service.EmployeeService;
import com.osnel97.springsmartshop.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/smart-shop")
public class EmployeeController {
private final EmployeeService employeeService;

@Autowired
public EmployeeController(EmployeeService employeeService){
    super();
    this.employeeService = employeeService;
}

@PostMapping("/employee/add")
public ResponseEntity<?> addemployee(@RequestBody Employee employee){
Optional<Employee> userIsExist = employeeService.findByEmail(employee.getEmail());
if(userIsExist.isPresent()){
    return ResponseEntity.badRequest().body("Email is Already Used by another User");
}
    Employee newEmployee = employeeService.addEmployee(employee);
    return new ResponseEntity<>(newEmployee, HttpStatus.OK);
}

@GetMapping("/employee/all")
public ResponseEntity<List<Employee>> getallEmployees(){
    List<Employee> employees = employeeService.findAllEmployees();
    return new ResponseEntity<>(employees, HttpStatus.OK);
}

@GetMapping("/employee/{id}")
public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
    Optional<Employee> employee = employeeService.findById(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
}

@PutMapping("/employee/update/{id}")
public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
Optional<Employee> userIsExist = employeeService.findById(id);
if(userIsExist.isPresent()){
Employee updateEmployee = employeeService.updateEmployee(id, employee);
return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
}
    return ResponseEntity.badRequest().body("User with the requested id is not found");
}

@DeleteMapping("/employee/delete/{id}")
public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
Optional<Employee> userIsExist = employeeService.findById(id);
if(userIsExist.isPresent()){
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.OK);
}
    return ResponseEntity.badRequest().body("User with the requested id is not found");
}

}
