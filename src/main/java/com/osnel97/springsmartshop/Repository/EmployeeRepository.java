package com.osnel97.springsmartshop.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osnel97.springsmartshop.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
Optional<Employee> findByEmail(String email);
}
