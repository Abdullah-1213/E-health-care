/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;


import static com.mycompany.main1.OpenPatientDashboard.formattedTime;
import static com.mycompany.main1.openPatientSignUpFrame.tempUinqueId;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Select_doctor {


       Select_doctor(String hospitalName,String doctorName,String Username1){
        String filePath = System.getProperty("user.home") + "/Desktop/PatientAppointments.txt";
        String filePath2= System.getProperty("user.home") + "/Desktop/PatientAppointments2.txt";
        String docted_lines="\n------------------------------------------------------";
        
        if (hospitalName.equals("Quaid e Azam International Hospital")){

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                 writer.write("Your Name: "+Username1+"\nHospital Name: "+hospitalName+"\n"+"Doctor Name: "+doctorName+"\nTiming : "+formattedTime+docted_lines);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                    //                   ------------------------
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath2, true))) {
                writer.write(tempUinqueId+","+Username1+","+doctorName+","+hospitalName+","+formattedTime);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }    
               MyAppointments myappointment =new MyAppointments(doctorName,Username1, hospitalName );   
           JOptionPane.showMessageDialog(null,"Your appointment booked with doctor"+doctorName);     
                
    }else if (hospitalName.equals("Agha Khan Hospital")){
                

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
               writer.write("Your Name: "+","+Username1+"\nHospital Name: "+hospitalName+"\n"+"Doctor Name: "+doctorName+"Timing : "+formattedTime+docted_lines);
                   
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                //                   ------------------------
                
             try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath2, true))) {
                writer.write(tempUinqueId+","+Username1+","+doctorName+","+hospitalName+","+formattedTime);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }       
                 MyAppointments myappointment =new MyAppointments(doctorName,Username1, hospitalName );  
            JOptionPane.showMessageDialog(null,"Your appointment booked with doctor"+doctorName);      
    } 
        
    }}
