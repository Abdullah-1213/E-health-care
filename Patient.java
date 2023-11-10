/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ayesha
 */
public class Patient {
    
    private String username;
    private String password;

    public Patient(String username, String password) {

        this.username = username;
        this.password = password;
    }

  
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
//    Select_doctor dc=new Select_doctor(getUsername());

    @Override
    public String toString() {
        return  username + "," + password;
    }


}

