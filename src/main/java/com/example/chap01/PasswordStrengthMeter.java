package com.example.chap01;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        if(password.length()<8) {
            return PasswordStrength.NORMAL;
        }
        boolean containsNum = false;
        for(char c : password.toCharArray()) {
            if (c>='0' && c<'9') {
                containsNum = true;
                break;
            }
        }
        if(!containsNum) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }
}
