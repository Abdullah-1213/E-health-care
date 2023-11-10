/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;

import javax.swing.JFrame;
import static com.mycompany.main1.openPatientSignUpFrame.tempUinqueId;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author Ayesha
 */
public class Sign_up extends JFrame {
    static String tempUinqueId1;
    static String tempUserName;
       static JTextField usernameField1;
      static String username2;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;
    private JButton signUpButton;
    private JButton loginButton;
    private String PATIENT_FILE_PATH =System.getProperty("user.home") + "/Desktop/Patient.txt";
    private  String DOCTOR_FILE_PATH=System.getProperty("user.home") + "/Desktop/Doctor.txt";
   
     

    public Sign_up() {
        initializeUI();
    }

   void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("eHealthcare System");
        setResizable(false);
        setLocationRelativeTo(null);
        JFrame Frame =new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        


        JLabel titleLabel = new JLabel("Welcome to eHealthcare System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        formPanel.add(new JLabel("Username:"));
        usernameField1 = new JTextField();
        usernameField1.setBackground(Color.LIGHT_GRAY);
        formPanel.add(usernameField1);

        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        passwordField.setBackground(Color.LIGHT_GRAY);
        formPanel.add(passwordField);

        formPanel.add(new JLabel("User Type:"));
        userTypeComboBox = new JComboBox<>(new String[]{"Patient", "Doctor", "Admin"});
        userTypeComboBox.setBackground(Color.LIGHT_GRAY);
        formPanel.add(userTypeComboBox);
        

        signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.LIGHT_GRAY);
        formPanel.add(new JLabel());
        formPanel.add(signUpButton);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                String selectedUserType = (String) userTypeComboBox.getSelectedItem();
                if (selectedUserType.equals("Doctor")) {
                    // Open Doctor Sign Up Frame
                    new openDoctorSignUpFrame();
                } else if (selectedUserType.equals("Patient")) {
                    // Open Patient Sign Up Frame
                    new openPatientSignUpFrame();
                }
            }
        });

        loginButton = new JButton("Login");
        loginButton .setBackground(Color.LIGHT_GRAY);
        formPanel.add(new JLabel());
        formPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username2 = usernameField1.getText();
                String password = new String(passwordField.getPassword());
                String selectedUserType = (String) userTypeComboBox.getSelectedItem();
                if (username2.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a username and password.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
               }
                if (selectedUserType.equals("Admin")) {
                    if (username2.equals("Admin") && password.equals("abd123")) {
                        // Open admin frame
                        new openadminframe();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid admin username or password!");
                    }
                } else if (selectedUserType.equals("Patient")) {

                     try {
                    BufferedReader reader = new BufferedReader(new FileReader(PATIENT_FILE_PATH));
                    String line;
                    boolean found = false;

                    while ((line = reader.readLine()) != null) {
                        String[] userData = line.split(",");

                        if (username2.equals(userData[0]) && password.equals(userData[1])) {
                            found = true;
                            break;
                        }
                    }

                    reader.close();

                    if (found) {
                      
                        JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                       OpenPatientDashboard open =new OpenPatientDashboard(username2) ;

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
               else if(selectedUserType.equals("Doctor"))  {
                  try {
                    BufferedReader reader = new BufferedReader(new FileReader(DOCTOR_FILE_PATH));
                    String line;
                    boolean found = false;

                    while ((line = reader.readLine()) != null) {
                        String[] userData = line.split(",");

                        if (username2.equals(userData[0]) && password.equals(userData[3])) {
                            found = true;
                            break;
                        }
                    }

                    reader.close();

                    if (found) {
                        JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
          
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                   
                }
            }
        });
        mainPanel.add(formPanel, BorderLayout.CENTER);
       
        getContentPane().add(mainPanel);


        pack();
        setSize(600, getHeight());
        // Adjust the width as per your preference
        setLocationRelativeTo(null);
        setVisible(true);
    }
}