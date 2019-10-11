package com.trilogyed.authorizationservice.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {

    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

//        String html = "html_5_secret";
//        String encodedHtml = enc.encode(html);
//        System.out.println("HTML SECRET ===== " + encodedHtml);
//
//        String android = "android_secret";
//        String encodedAndroid = enc.encode(android);
//        System.out.println("ANDROID SECRET ===== " + encodedAndroid);
//
//        String iphone = "i_phone_secret";
//        String encodedIPhone = enc.encode(iphone);
//        System.out.println("IPHONE SECRET ===== " +encodedIPhone);

        /*
        Users:
      * jdoe
        * Password (Bcrypt hashed): jdoeRoCkS!!!
        * Authorities: ROLE_ADMIN
      * ssmith
        * Password (Bcrypt hashed): pwdPWDpwd!
        * Authorities: ROLE_LVL1
         */
//
//        String jdoe = "jdoeRoCkS!!!";
//        String encodedJoe = enc.encode(jdoe);
//        System.out.println("JOE PASSWORD ===== " + encodedJoe);
//
//        String ssmith = "pwdPWDpwd!";
//        String encodedSmith = enc.encode(ssmith);
//        System.out.println("SSMITH ===== " + encodedSmith);


    }
}
