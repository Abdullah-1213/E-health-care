/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;

/**
 *
 * @author Ayesha
 */
public class doctor {
     private String firstName;
    private String lastname;
    private String password;
    private String specialty;
    private String selectedUniversity;

    public doctor (String firstName, String username, String specialty,String password,String selectedUniversity) {
        this.firstName = firstName;
        this.lastname = username;
        this. specialty=specialty;
        this.password = password;
        this.selectedUniversity=selectedUniversity;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return lastname;
    }
    public String getSpecialty() {
        return specialty;
    }
    public String getPassword() {
        return password;
    }
    public String getSelectedUniversity() {
        return selectedUniversity;
    }
    @Override
    public String toString() {
        return "First Name: " + firstName +
                ", Lastname: " + lastname +
                ", Specialty: "+specialty+
                ", Password: " + password +
                ", selectedUniversity"+selectedUniversity;
    }

}
