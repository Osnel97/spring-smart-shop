package com.osnel97.springsmartshop.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_tbl")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String gender;
    private String jobtitle;
    private String phone;

    public Employee(){

    }

    public Employee(String fname, String lname, String email, String password, String jobtitle, String phone, String gender ){
    super();
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.password = password;
    this.jobtitle = jobtitle;
    this.phone = phone;
    this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobTitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
    this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password + ", jobTitle="
                + jobtitle + ", phone=" + phone + ", gender=" + gender + "]";
    }
    
}

