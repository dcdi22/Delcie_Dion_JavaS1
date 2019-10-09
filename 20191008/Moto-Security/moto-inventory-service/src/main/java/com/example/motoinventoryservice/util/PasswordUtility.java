package com.example.motoinventoryservice.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {
    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String managerPassword = "password";
        String salesPassword = "password";

        String encodedPasswordM = enc.encode(managerPassword);
        String encodedPasswordS = enc.encode(salesPassword);

        System.out.println("This is Managers Password" + encodedPasswordM);
        System.out.println("This is Sales Persons Password" + encodedPasswordS);

    }
}
