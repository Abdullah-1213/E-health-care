/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;

/**
 *
 * @author Ayesha
 */
import static com.mycompany.main1.OpenPatientDashboard.formattedTime;
import static com.mycompany.main1.Sign_up.username2;
import static com.mycompany.main1.Sign_up.usernameField1;
import static com.mycompany.main1.Sign_up.tempUinqueId1;
import static com.mycompany.main1.Sign_up.tempUserName;
import static com.mycompany.main1.openPatientSignUpFrame.tempUinqueId;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class MyAppointments  extends JFrame{
    private JTextArea patientTextArea; // Text area to display patient data
     
      String filePath2= System.getProperty("user.home") + "/Desktop/PatientAppointments2.txt";
     
     static String doctor_name;
     static String Username;
     static String hospital_name;
     MyAppointments(String doctor_name,String Username, String hospital_name ){
         this.doctor_name=doctor_name;
         this.Username=Username;
         this.hospital_name=hospital_name;
         
     }
        

     MyAppointments(){

         
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
                managePatientsFrame.setVisible(true);

                    tempUserName=usernameField1.getText(); 

                try {
                        BufferedReader br = new BufferedReader(new FileReader(filePath2));
                        String line1;
                    while ((line1 = br.readLine()) != null) {
                        String[] data = line1.split(",");
                        
                        if ( data.length>2 && data[1].equals(username2)) {
                            
                                tempUinqueId=Integer.parseInt(data[0]);
                                tempUinqueId1=data[0];
                                
                            
                        }
                    }
                    br.close();
                }catch (IOException ex) {
                    ex.printStackTrace();
                }

                String num="Your Unique Id : ";
               String yourname="\nYour name: ";
                String doctorname="\nAppointment with doctor name: ";
                String hosptalname="\nhospital name: ";
                String Timing="\nAppointment Timing ";
                String dotedline="\n-------------------------------------------------------------------------";
                
              try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) {
                  StringBuilder patientData = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
            
                if (data[0].equals(tempUinqueId1)&&data[1].equals(tempUserName) ) {
                    patientData.append(num+data[0]+yourname+data[1]+doctorname+data[2]+hosptalname+data[3]+Timing+data[4]+dotedline).append(System.lineSeparator());
            }
                patientTextArea.setText(patientData.toString());
            }
            
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

             
              
 
     
         

     



