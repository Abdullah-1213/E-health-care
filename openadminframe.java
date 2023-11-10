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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Ayesha
 */
public class openadminframe {

    private JTextArea patientTextArea; // Text area to display patient data

     private JTextArea doctorTextArea;
     private String filePath;
    public openadminframe() {
        JFrame adminDashboardFrame = new JFrame();
        adminDashboardFrame.setTitle("Admin Dashboard");
        adminDashboardFrame.setSize(650, 300);
        adminDashboardFrame.setLayout(new GridLayout(4, 5, 2, 5));
        adminDashboardFrame.setResizable(false);
        adminDashboardFrame.setLocationRelativeTo(null);//center the console

        
        JButton manageDoctorsButton = new JButton("Manage Doctors");
        manageDoctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame manageDoctorsFrame = new JFrame();
                manageDoctorsFrame.setTitle("Manage Doctors");
                manageDoctorsFrame.setSize(400, 300);
                manageDoctorsFrame.setResizable(false);
                manageDoctorsFrame.setLocationRelativeTo(null);
                manageDoctorsFrame.setLayout(new BorderLayout());

                doctorTextArea = new JTextArea();
                doctorTextArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(doctorTextArea);
                manageDoctorsFrame.add(scrollPane, BorderLayout.CENTER);

                String filePath = System.getProperty("user.home") + "/Desktop/Doctor.txt";
                loadDoctorData(doctorTextArea, filePath);

                JButton verifyButton = new JButton("Verify");
                verifyButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedDoctor = doctorTextArea.getSelectedText();
                        if (selectedDoctor != null) {
                            
                            JOptionPane.showMessageDialog(manageDoctorsFrame, "Doctor verified successfully.");
                        } else {
                            JOptionPane.showMessageDialog(manageDoctorsFrame, "Please select a doctor.");
                        }
                    }
                });

                manageDoctorsFrame.add(verifyButton, BorderLayout.SOUTH);
                manageDoctorsFrame.setVisible(true);
            }
        });

        adminDashboardFrame.add(manageDoctorsButton);
        adminDashboardFrame.setVisible(true);
  
            JButton managePatientsButton = new JButton("Manage Patients");
        managePatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame managePatientsFrame = new JFrame();
                managePatientsFrame.setTitle("Manage Patients");
                managePatientsFrame.setSize(400, 300);
                managePatientsFrame.setResizable(false);
                managePatientsFrame.setLocationRelativeTo(null);
                managePatientsFrame.setLayout(new BorderLayout());

                patientTextArea = new JTextArea();
                patientTextArea.setEditable(false);

                // Add the JTextArea to a JScrollPane to enable scrolling if needed
                JScrollPane scrollPane = new JScrollPane(patientTextArea);
                managePatientsFrame.add(scrollPane, BorderLayout.CENTER);

                filePath = System.getProperty("user.home") + "/Desktop/Patient.txt";
                loadPatientData(filePath); // Load and display the patient data initially

                JButton deleteButton = new JButton("Delete");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedPatient = patientTextArea.getSelectedText();
                        if (selectedPatient != null) {
                            // Remove the selected patient from the JTextArea
                            String currentText = patientTextArea.getText();
                            String updatedText = currentText.replace(selectedPatient, "");
                            patientTextArea.setText(updatedText);
                            // Update the patient data in the file
                            updatePatientData(updatedText);
                        }else{
                            JOptionPane.showMessageDialog(null, "Please Select data.");
                        }
                    }
                });
                managePatientsFrame.add(deleteButton, BorderLayout.SOUTH);

                managePatientsFrame.setVisible(true);
            }
        });
        adminDashboardFrame.add(managePatientsButton);



        JButton manageAppointmentsButton = new JButton("Manage Patient Appointments");
        manageAppointmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 String filePath= System.getProperty("user.home") + "/Desktop/PatientAppointments.txt";  
                
                JFrame managePatientsFrame = new JFrame();
                managePatientsFrame.setTitle("Manage Patients appointment");
                managePatientsFrame.setSize(600, 500);
                managePatientsFrame.setResizable(false);
                managePatientsFrame.setLocationRelativeTo(null);
                managePatientsFrame.setLayout(new BorderLayout());

                patientTextArea = new JTextArea();
                patientTextArea.setEditable(false);

                // Add the JTextArea to a JScrollPane to enable scrolling if needed
                JScrollPane scrollPane = new JScrollPane(patientTextArea);
                managePatientsFrame.add(scrollPane, BorderLayout.CENTER);

 
                loadPatientData(filePath);
                
                
               JButton deleteButton = new JButton("Delete");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        patientTextArea.setText("");
                        DeletedData(filePath);
                        JOptionPane.showMessageDialog(null, "Successfully Deleted Patients Appointments Details.");
                        
                    }
                });
                managePatientsFrame.add(deleteButton, BorderLayout.SOUTH);
                managePatientsFrame.setVisible(true);
                
                
                
            }
        });
        adminDashboardFrame.add(manageAppointmentsButton);
        
        JButton ViewfeedbackButton = new JButton("View Feedback");
        ViewfeedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame feedbackFrame = new JFrame();
                feedbackFrame.setTitle("View Feedback");
                feedbackFrame.setSize(400, 300);
                feedbackFrame.setLocationRelativeTo(null);
                feedbackFrame.setLayout(new BorderLayout());

                JTextArea feedbackTextArea = new JTextArea();
                feedbackTextArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(feedbackTextArea);
                feedbackFrame.add(scrollPane, BorderLayout.CENTER);
                String filePath = System.getProperty("user.home") + "/Desktop/Feedback.txt";
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder feedbackData = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        feedbackData.append(line);
                        feedbackData.append("\n");
                    }
                    feedbackTextArea.setText(feedbackData.toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                feedbackFrame.setVisible(true);
            }
        });
        adminDashboardFrame.add(ViewfeedbackButton);
        

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(adminDashboardFrame, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the application
                }
            }
        });
        adminDashboardFrame.add(logoutButton);

        adminDashboardFrame.setVisible(true);
    }

    private void loadPatientData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder patientData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                patientData.append(line).append(System.lineSeparator());
            }
            patientTextArea.setText(patientData.toString()); // Set the patient data to the JTextArea
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 

    private void DeletedData(String filePath){
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Truncate the file by writing an empty string
            writer.write("");
            
        } catch (IOException e) {
            
    }
    }
        private void updatePatientData(String updatedData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(updatedData);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }}


//        public void verifyDoctor(String doctorData) {
//        // Perform the verification logic for the doctor
//        // Update the doctor data in the file or
//
//        // Extract necessary information from doctorData
//        // Retrieve the doctor's data from a file
//
//        // Update the doctor's verification status
//        String filePath = System.getProperty("user.home") + "/Desktop/Doctor.txt";
//        String[] doctorFields = doctorData.split(",");
//        String doctorId = doctorFields[0];
//        boolean isVerified = true; // Update this based on your verification logic
//
//        // Update the doctor's verification status in the data
//        String updatedDoctorData = "";
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] fields = line.split(",");
//                if (fields[0].equals(doctorId)) {
//                    fields[2] = String.valueOf(isVerified);
//                }
//                updatedDoctorData += String.join(",", fields) + System.lineSeparator();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        // Write the updated doctor data back to the file
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            writer.write(updatedDoctorData);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        // Update the doctor data in the JTextArea
//        loadDoctorData(doctorTextArea, filePath);
//    }
            private void loadDoctorData(JTextArea doctorTextArea, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder doctorData = new StringBuilder();//. It will be used to store the content read from the file.
            String line;
            while ((line = reader.readLine()) != null) {
                doctorData.append(line).append(System.lineSeparator());
            }
            doctorTextArea.setText(doctorData.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    

}