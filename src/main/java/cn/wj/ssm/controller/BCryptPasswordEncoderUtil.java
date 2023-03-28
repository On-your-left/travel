package cn.wj.ssm.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtil {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encoderPassword(String password){
        String encoderPasswordStr = bCryptPasswordEncoder.encode(password);
        return encoderPasswordStr;
    }

    public static void main(String[] args) {
        String s = encoderPassword("abc");
        System.out.println(s);
    }
}