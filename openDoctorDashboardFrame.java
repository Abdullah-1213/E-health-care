/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;

import static com.mycompany.main1.MyAppointments.Username;
import static com.mycompany.main1.MyAppointments.doctor_name;
import static com.mycompany.main1.MyAppointments.hospital_name;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Ayesha
 */
public class openDoctorDashboardFrame {

    public openDoctorDashboardFrame() {
      
    JFrame doctorDashboardFrame = new JFrame();
    doctorDashboardFrame.setTitle("Doctor Dashboard");
    doctorDashboardFrame.setSize(650, 300);
    doctorDashboardFrame.setLayout(new GridLayout(5,4,2,2));
    doctorDashboardFrame.setResizable(false);
     doctorDashboardFrame.setLocationRelativeTo(null);

    JButton appointmentsButton = new JButton("My Appointments");
    appointmentsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                doctor_appointments Doctor_App=new doctor_appointments();
        } 
    });
    doctorDashboardFrame.add(appointmentsButton);

    JButton patientListButton = new JButton("Patient List");
    patientListButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filePath=System.getProperty("user.home") + "/Desktop/Patient.txt";
            JTextArea PatientList;
                JFrame managePatientsFrame = new JFrame();
                managePatientsFrame.setTitle("Manage Patients");
                managePatientsFrame.setSize(400, 300);
                managePatientsFrame.setResizable(false);
                managePatientsFrame.setLocationRelativeTo(null);
                managePatientsFrame.setLayout(new BorderLayout());

                PatientList = new JTextArea();
                PatientList .setEditable(false);

                // Add the JTextArea to a JScrollPane to enable scrolling if needed
                JScrollPane scrollPane = new JScrollPane(PatientList);
                managePatientsFrame.add(scrollPane, BorderLayout.CENTER);
                managePatientsFrame.setVisible(true);
//               String yourname="Doctor Name: "+doctor_name;
//                String doctorname="\nAppointment with patient  name: "+Username;
//                String hosptalname="\nhospital name: "+hospital_name;
//                String dotedline="\n-------------------------------------------------------------------------";
   
//              PatientList .append(yourname+doctorname+hosptalname+dotedline);
//                  BufferedReader reader = null;
//                    try {
//                        reader = new BufferedReader(new FileReader(filePath));
//                        String line;
//                        int index = 0;
//                        while ((line = reader.readLine()) != null) {
//                            if (index == 0) {
//                                PatientList.append(line);
//                                break;
//                            }
//                            index++;
//                        }
//                    } finally {
//                        if (reader != null) {
//                            reader.close();
//                        }
//                    }
//                    
                    
                    
                    
                  int index=0;   
                    
                    BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filePath));
            } catch (FileNotFoundException ex) {
               
            }
                    String line;
                    
                        
                    
            try {
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(",");
                    
                    PatientList.append("Patient "+(index+1)+": \t"+userData[0]+"\n");
                    index++;


                }
            } catch (IOException ex) {
               
            }

            finally{
                try {
                    reader.close();
                } catch (IOException ex) {
                    
                }
            } 
                        }
    });
    doctorDashboardFrame.add(patientListButton);

    JButton prescriptionButton = new JButton("Medicine Prescription");
    prescriptionButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
    });
    doctorDashboardFrame.add(prescriptionButton);

    JButton logoutButton = new JButton("Logout");
    logoutButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the application
                }
        }
    });
    doctorDashboardFrame.add(logoutButton);

    doctorDashboardFrame.setVisible(true);
}
    }
    
    


