package com.osnel97.springsmartshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osnel97.springsmartshop.Service.EmployeeService;
import com.osnel97.springsmartshop.Service.AuthService;
import com.osnel97.springsmartshop.model.Employee;
import com.osnel97.springsmartshop.model.Login;

@RestController
@RequestMapping("/smart-shop/auth")
public class LoginController {
    private final EmployeeService employeeService;
    private final AuthService authService;

    @Autowired
    public LoginController(EmployeeService employeeService, AuthService authService){
    super();
    this.employeeService = employeeService;
    this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login){
    Employee loginemployee = employeeService.findByEmail(login.getEmail()).orElseThrow(null);

    if(loginemployee != null && authService.checkPassword(login.getPassword(), loginemployee.getPassword())){
        return ResponseEntity.ok().build();
    }
    else{
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    }
}
