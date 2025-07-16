package com.hhstechgroup.common;

/**
 * Roles class represents a group of constants (unchangeable variables)
 */
public enum Roles {

    APPEALS_PROCESSOR("Appeals Processor");

    private String role;

    /**
     * This method returns a string from Roles class
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * This is a parameterized constructor
     * @param role
     */
    Roles(String role) {
        this.role = role;

    }

}
