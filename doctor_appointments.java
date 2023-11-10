/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;

/**
 *
 * @author Ayesha
 */
import static com.mycompany.main1.MyAppointments.Username;
import static com.mycompany.main1.MyAppointments.doctor_name;
import static com.mycompany.main1.MyAppointments.hospital_name;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author HamzaAshiq
 */
public class doctor_appointments {
     private JTextArea DoctorTextArea;
    doctor_appointments(){
                
                JFrame managePatientsFrame = new JFrame();
                managePatientsFrame.setTitle("Manage Patients");
                managePatientsFrame.setSize(400, 300);
                managePatientsFrame.setResizable(false);
                managePatientsFrame.setLocationRelativeTo(null);
                managePatientsFrame.setLayout(new BorderLayout());

                DoctorTextArea = new JTextArea();
                DoctorTextArea.setEditable(false);

                // Add the JTextArea to a JScrollPane to enable scrolling if needed
                JScrollPane scrollPane = new JScrollPane(DoctorTextArea);
                managePatientsFrame.add(scrollPane, BorderLayout.CENTER);
                managePatientsFrame.setVisible(true);
               String yourname="Doctor Name: "+doctor_name;
                String doctorname="\nAppointment with patient  name: "+Username;
                String hosptalname="\nhospital name: "+hospital_name;
                String dotedline="\n-------------------------------------------------------------------------";
              DoctorTextArea.append(yourname+doctorname+hosptalname+dotedline);
    }
}
