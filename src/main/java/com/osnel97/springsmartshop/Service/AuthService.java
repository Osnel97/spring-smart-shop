package com.osnel97.springsmartshop.Service;

public interface AuthService {
    boolean checkPassword(String password, String hashcodePassword);
    
}
