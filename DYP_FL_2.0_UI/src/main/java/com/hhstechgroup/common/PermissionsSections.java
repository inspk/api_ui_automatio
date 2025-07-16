package com.hhstechgroup.common;

/**
 * PermissionsSections class represents a group of constants (unchangeable variables)
 */
public enum PermissionsSections {

    GENERAL("General"), DASHBOARD("Dashboard - Display page");

    private String permissionSection;

    /**
     * This method returns a string from PermissionsSections class
     * @return
     */
    public String getPermissionSection() {
        return permissionSection;
    }

    /**
     * This is a parameterized constructor
     * @param permissionSection
     */
    PermissionsSections(String permissionSection) {
        this.permissionSection = permissionSection;

    }

}
