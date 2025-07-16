package com.hhstechgroup.common;

/**
 * Permissions class represents a group of constants (unchangeable variables)
 */
public enum Permissions {

    READ("Read");

    private String permission;

    /**
     * This method returns a string from Permissions class
     * @return
     */
    public String getPermission() {
        return permission;
    }

    /**
     * This is a parameterized constructor
     * @param permission
     */
    Permissions(String permission) {
        this.permission = permission;

    }

}
