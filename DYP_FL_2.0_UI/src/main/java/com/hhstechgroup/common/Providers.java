package com.hhstechgroup.common;

import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * Providers class contains a number of useful miscellaneous methods to get provider's info which are generally
 * informational and would be used accordingly.
 */
public class Providers {
    private String firstName;
    private String lastName;
    private String email;
    private String address1;
    private String zipCode;
    private String ssn;
    private String npi;
    private String authorEmail;

    /**
     *This method returns the firstName
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method returns the lastName
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method returns the email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method returns the address
     * @return
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * This method returns the zipCode
     * @return
     */
    public String getZip() {
        return zipCode;
    }

    /**
     * This method returns the SSN
     * @return
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * This method returns the NPI
     * @return
     */
    public String getNpi() {
        return npi;
    }

    /**
     * This method returns the author email
     * @return
     */
    public String getAuthorEmail() {
        return authorEmail;
    }

    /**
     * This is a parameterized constructor
     * @param firstName
     * @param lastName
     * @param email
     * @param address1
     * @param zipCode
     * @param ssn
     */
    public Providers(String firstName, String lastName, String email, String address1, String zipCode, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address1 = address1;
        this.zipCode = zipCode;
        this.ssn = ssn;

    }

    static int counter = 0;

    /**
     * This is a parameterized constructor
     * @param map
     */
    public Providers(LinkedHashMap<String, LinkedHashMap<String, Object>> map) {
        System.out.println(counter++);
        try {
            this.firstName = (String) map.get("provider").get("firstName");
            this.lastName = (String) map.get("provider").get("lastName");
            this.email = (String) map.get("provider").get("appContactEmail");
            this.authorEmail = (String) map.get("author").get("email");
            this.ssn = (String) map.get("provider").get("ssn");
            try {

            } catch (Exception e) {
            }
            this.npi = (String) map.get("provider").get("npi");
            try {
                this.address1 = (String) ((LinkedHashMap) ((LinkedHashMap) ((LinkedHashMap) map.get("provider").get("address")).get("mailing")).get("address")).get("text").toString();
            } catch (Exception e) {
            }
            try {
                this.zipCode = (String) ((LinkedHashMap) ((LinkedHashMap) map.get("provider").get("address")).get("mailing")).get("zip");
            } catch (Exception e) {
            }

        } catch (Throwable t) {
            System.out.println(map.getClass().getName());
            System.out.println(map);
        }
    }

    /**
     * This method returns a boolean
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.hhstechgroup.common.Providers providers = (com.hhstechgroup.common.Providers) o;
        return Objects.equals(firstName, providers.firstName) &&
                Objects.equals(lastName, providers.lastName) &&
                Objects.equals(email, providers.email) &&
                Objects.equals(address1, providers.address1) &&
                Objects.equals(zipCode, providers.zipCode) &&
                Objects.equals(ssn, providers.ssn);

    }

    /**
     * This method returns an integer
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, address1, zipCode, ssn);
    }

    /**
     * This method returns a string
     * @return
     */
    @Override
    public String toString() {
        return "Providers{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address1='" + address1 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", ssn='" + ssn + '\'' +
                ", npi='" + npi + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                '}';
    }

    /**
     * This method prints provider's info
     */
    public void printMe() {
        System.out.println("{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address1='" + address1 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", ssn='" + ssn + '\'' +
                '}');
    }
}





