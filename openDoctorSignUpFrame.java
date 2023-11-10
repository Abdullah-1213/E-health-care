/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class openDoctorSignUpFrame {

    public openDoctorSignUpFrame() {
        JFrame doctorSignUpFrame = new JFrame();
        doctorSignUpFrame.setTitle("Doctor Sign Up");
        doctorSignUpFrame.setSize(650, 300);
        doctorSignUpFrame.setLayout(new BorderLayout());
        doctorSignUpFrame.setResizable(false);
        doctorSignUpFrame.setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Doctor Sign Up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        doctorSignUpFrame.add(titleLabel, BorderLayout.NORTH);

        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField();
         firstNameField .setBackground(Color.LIGHT_GRAY);
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField();
        lastNameField .setBackground(Color.LIGHT_GRAY);
        JLabel specialtyLabel = new JLabel("Specialty:");
        JTextField specialtyField = new JTextField();
        specialtyField.setBackground(Color.LIGHT_GRAY);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(Color.LIGHT_GRAY);
        JLabel universityLabel = new JLabel("University:");
        JComboBox<String> universityComboBox = new JComboBox<>(new String[]{"King Adward Medical College", "Allama Iqbal Medial college", "Ayub medical College"});
        universityComboBox.setBackground(Color.LIGHT_GRAY);
        formPanel.add(firstNameLabel);
        formPanel.add(firstNameField);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);
        formPanel.add(specialtyLabel);
        formPanel.add(specialtyField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(universityLabel);
        formPanel.add(universityComboBox);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.LIGHT_GRAY);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String specialty = specialtyField.getText();
                String password=passwordField.getText();
                String selectedUniversity = (String) universityComboBox.getSelectedItem();
                if (firstName.isEmpty() || lastName.isEmpty() || specialty.isEmpty()|| password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill this form.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
               }
            doctor doctors=new doctor(firstName, lastName,  specialty, password,selectedUniversity);
             String filePath = System.getProperty("user.home") + "/Desktop/Doctor.txt";
              try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(doctors.getFirstName()+","+doctors.getUsername()+","+doctors.getSpecialty()+","+doctors.getPassword()+","+doctors.getSelectedUniversity());
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                JOptionPane.showMessageDialog(null, "Doctor Sign Up" +
                        "\nFirst Name: " + firstName +
                        "\nLast Name: " + lastName +
                        "\nSpecialty: " + specialty +
                        "\nPassword: " + password +
                        "\nUniversity: " + selectedUniversity);
            }
        });
         signUpButton.setBackground(Color.PINK);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(signUpButton);

        doctorSignUpFrame.add(formPanel, BorderLayout.CENTER);
        doctorSignUpFrame.add(buttonPanel, BorderLayout.SOUTH);

        doctorSignUpFrame.setVisible(true);
    }
}

 

