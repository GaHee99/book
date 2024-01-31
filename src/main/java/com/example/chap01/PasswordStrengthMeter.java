package com.example.chap01;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        if(password==null || password.isBlank()) return PasswordStrength.INVALID;
        boolean lengthEnough = password.length()>=8;
        boolean containsNum = meetsContainingNumber(password);
        boolean containsUpp = meetsContainingUpps(password);

        if(lengthEnough && !containsNum && !containsUpp) return PasswordStrength.WEAK;
        if(containsNum && !lengthEnough && !containsUpp) return PasswordStrength.WEAK;
        if(containsUpp && !lengthEnough && !containsNum) return PasswordStrength.WEAK;

        if(!lengthEnough) return PasswordStrength.NORMAL;
        if(!containsNum) return PasswordStrength.NORMAL;
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
