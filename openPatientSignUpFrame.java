/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class openPatientSignUpFrame extends JFrame{
    
   
    static int randomNumber=0;
    
    static int tempUinqueId=0;
   public void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100000);
        tempUinqueId=randomNumber ;
        
    }
        
   

    private JTextField userNameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public openPatientSignUpFrame() {
        setTitle("Patient Sign Up");
        setSize(650, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        setContentPane(contentPane);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel usernameLabel = new JLabel("Username:");
        userNameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField();

        formPanel.add(usernameLabel);
        formPanel.add(userNameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(confirmPasswordLabel);
        formPanel.add(confirmPasswordField);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomNumber();
                String username = userNameField.getText();
                
                
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                
                if (username.isEmpty() || password .isEmpty()|| confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill this form.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
               }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
                    return;
                }
                if(password.length()<8 && confirmPassword.length()<8){
                     JOptionPane.showMessageDialog(null, "Password Must be Greater than 8 characters .");
                    return;
                }
               
                   // Check if username already exists in the patient file
                String filePath = System.getProperty("user.home") + "/Desktop/Patient.txt";
                boolean usernameExists = checkUsernameExists(filePath, username);

                if (usernameExists) {
                    JOptionPane.showMessageDialog(null, "Username already exists. Please choose a unique name.");
                    return;
                }


                Patient patient = new Patient(username, password);


                writePatientDataToFile(filePath, patient);


                JOptionPane.showMessageDialog(null, "Patient Sign Up" +
                        "\nUsername: " + username +
                        "\nPassword: " + password);
            }
        });

        formPanel.add(new JLabel());
        formPanel.add(signUpButton);

        contentPane.add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    
    private boolean checkUsernameExists(String filePath, String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 1 && tokens[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void writePatientDataToFile(String filePath, Patient patient) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(patient.getUsername()+","+patient.getPassword()+","+randomNumber);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
}

