package com.osnel97.springsmartshop.Service.Implements;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.osnel97.springsmartshop.Service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

@Override
public boolean checkPassword(String password, String hashcodePassword) {
return BCrypt.checkpw(password, hashcodePassword);
}

}
