package com.company.encapsulation.entity;
//User entity
public class User {

    private String name;

    private String email;

    private String tier;

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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tier
     */
    public String getTier() {
        return tier;
    }

    /**
     * @param tier the tier to set
     */
    public void setTier(String tier) {
        this.tier = tier;
    }

}