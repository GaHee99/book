package com.example.chap01;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        if(password==null || password.isBlank()) return PasswordStrength.INVALID;
        int metCount = 0;
        boolean lengthEnough = password.length()>=8;
        if(lengthEnough) metCount++;
        boolean containsNum = meetsContainingNumber(password);
        if(containsNum) metCount++;
        boolean containsUpp = meetsContainingUpps(password);
        if(containsUpp) metCount++;

        if(metCount<=1) return PasswordStrength.WEAK;
        if(metCount==2) return PasswordStrength.NORMAL;
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
