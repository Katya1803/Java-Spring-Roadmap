package com.company.dry_ex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public UserValidator() {

    }

    public boolean isValid(User user) {
        return true;
    }

    private boolean isValidFirstName(String firstName) {
        if(firstName == null || firstName.trim().length() == 0) {
            return false;
        }
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]"); //negative 
        Matcher matcher = pattern.matcher(firstName);
        return !matcher.find();
    }

    private boolean isValidLastName(String lastName) {
        if(lastName == null) {
            return false;
        }
        if(lastName.trim().length() == 0) {
            return false;
        }

        Pattern pat = Pattern.compile("[^A-Za-z0-9]"); //negative 
        boolean hasSpecialChars = pat.matcher(lastName).find();
        return !hasSpecialChars;
    }

    private boolean isValidTagline(String tagline) {
        if(tagline == null || tagline.trim().length() == 0)
            return true;
        return !Pattern.compile("[^A-Za-z0-9]").matcher(tagline).find();
    }

}