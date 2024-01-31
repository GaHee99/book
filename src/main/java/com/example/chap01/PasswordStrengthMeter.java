package com.example.chap01;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        if(password.isBlank()) return PasswordStrength.INVALID;
        if(password.length()<8) {
            return PasswordStrength.NORMAL;
        }
        boolean containsNum = meetsContainingNumber(password);
        if(!containsNum) return PasswordStrength.NORMAL;

        boolean containsUpp = meetsContainingUpps(password);
        if(!containsUpp) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }
    private boolean meetsContainingUpps(String s) {
        for(char c : s.toCharArray()) {
            if(Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingNumber(String s){
        for(char ch : s.toCharArray()){
            if(ch>='0' && ch<='9'){
                return true;
            }
        }
        return false;
    }

}
