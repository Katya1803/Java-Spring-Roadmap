package com.company.encapsulation_ex.entity;

public class User {

    private String name;

    private String email;

    public User() {

    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param password the password to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
}