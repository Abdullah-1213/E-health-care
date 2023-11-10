/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main1;
import java.util.concurrent.ThreadLocalRandom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class OpenPatientDashboard {
    static String formattedTime;
    

     String Username;

    public OpenPatientDashboard(String Username) {
        this.Username=Username;
        JFrame patientDashboardFrame = new JFrame();
        patientDashboardFrame.setTitle("Patient Dashboard");
        patientDashboardFrame.setSize(650, 300);
        patientDashboardFrame.setLayout(new GridLayout(4,5,2,5));
        patientDashboardFrame.setResizable(false);
        patientDashboardFrame.setLocationRelativeTo(null);

        //consult button
        JButton consultButton = new JButton("Consult a Doctor");
        consultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for "Consult a Doctor" button
                JFrame consultationFrame = new JFrame();
                consultationFrame.setTitle("Consult a Doctor");
                consultationFrame.setSize(650, 300);
                consultationFrame.setLayout(new GridLayout(5,4,3,2));
                consultationFrame.setResizable(false);
                consultationFrame.setLocationRelativeTo(null);

                JLabel label = new JLabel("Choose a Hospital:");
                consultationFrame.add(label);

                JButton quaidAzamButton = new JButton("Quaid e Azam International Hospital");
                quaidAzamButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Logic for "Quaid e Azam International Hospital" button
                        openDoctorListFrame("Quaid e Azam International Hospital");
                        JOptionPane.showMessageDialog(null, "Consulting with Quaid e Azam International Hospital");
                        consultationFrame.dispose();
                    }
                });
                consultationFrame.add(quaidAzamButton);

                JButton aghaKhanButton = new JButton("Agha Khan Hospital");
                aghaKhanButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Logic for "Agha Khan Hospital" button
                         openDoctorListFrame("Agha Khan Hospital");
                        JOptionPane.showMessageDialog(null, "Consulting with Agha Khan Hospital");
                        consultationFrame.dispose();
            }
        });
        consultationFrame.add(aghaKhanButton);

        consultationFrame.setVisible(true);

            }
        });
        
        patientDashboardFrame.add(consultButton);
        
        //Myappointment button

        JButton appointmentButton = new JButton("My Appointment");
        appointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                 MyAppointments appointment = new MyAppointments();
               
                
                    
            }
        });
        patientDashboardFrame.add(appointmentButton);
        
        //Feedback button
        
        JButton feedbackButton = new JButton("Feedback");
        feedbackButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea patientTextArea;
            JTextField usernameField;
            JTextField doctorNameField;
            String filePath = System.getProperty("user.home") + "/Desktop/Feedback.txt";
            JFrame managePatientsFrame = new JFrame();
            managePatientsFrame.setTitle("Manage Patients");
            managePatientsFrame.setSize(650, 300);
            managePatientsFrame.setResizable(false);
            managePatientsFrame.setLocationRelativeTo(null);
            managePatientsFrame.setLayout(new BorderLayout());

            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridLayout(6, 4));

            JLabel usernameLabel = new JLabel("Username:");
            usernameField = new JTextField();
            inputPanel.add(usernameLabel);
            inputPanel.add(usernameField);

            JLabel doctorLabel = new JLabel("Doctor:");
            doctorNameField = new JTextField();
            inputPanel.add(doctorLabel);
            inputPanel.add(doctorNameField);

            JLabel feedbackLabel = new JLabel("Feedback:");
            patientTextArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(patientTextArea);
            inputPanel.add(feedbackLabel);
            inputPanel.add(scrollPane);

            JPanel buttonPanel = new JPanel();
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText(); // Retrieve the username
                    String doctorName = doctorNameField.getText(); // Retrieve the doctor's name
                    String feedback = patientTextArea.getText(); // Retrieve the feedback text
                    usernameField.setText(""); // Clear the username input
                    doctorNameField.setText(""); // Clear the doctor's name input
                    patientTextArea.setText(""); // Clear the feedback text

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                        writer.write("Username: " + username); // Write the username
                        writer.newLine();
                        writer.write("Doctor: " + doctorName); // Write the doctor's name
                        writer.newLine();
                        writer.write("Feedback: " + feedback); // Write the feedback
                        writer.newLine();
                        writer.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    managePatientsFrame.dispose(); // Close the frame
                }
            });

            managePatientsFrame.add(inputPanel, BorderLayout.CENTER);
            buttonPanel.add(submitButton);
            managePatientsFrame.add(buttonPanel, BorderLayout.SOUTH);

            managePatientsFrame.setVisible(true);
        }
    });

    //------------------------------------------------------------------------
            
         patientDashboardFrame.add(feedbackButton);
        //contact us button
        JButton Contactus = new JButton("Contact us ");
        Contactus.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
                // Logic for  Contact Us" button

            JFrame contactFrame = new JFrame();
            contactFrame.setTitle("Contact Us");
            contactFrame.setSize(650, 300);
            contactFrame.setResizable(false);
            contactFrame.setLocationRelativeTo(null);

            JPanel contactPanel = new JPanel(new GridLayout(3, 1, 10, 10));
            contactPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel ContactLabel = new JLabel("Contact : (051)333333");
            JLabel emailLabel = new JLabel("Email: Ehealthcare@example.com");
            JLabel addressLabel = new JLabel("Address: 123 Main Street, Lahore");

            contactPanel.add(ContactLabel);
            contactPanel.add(emailLabel);
            contactPanel.add(addressLabel);

            contactFrame.add(contactPanel);
            contactFrame.setVisible(true);
        }
    });
            patientDashboardFrame.add(Contactus);
                   
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(patientDashboardFrame, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the application
                }
            }
        });
        patientDashboardFrame.add(logoutButton);

        patientDashboardFrame.setVisible(true);
    }
    
    
    private void openDoctorListFrame(String hospitalName) {
        JFrame doctorListFrame = new JFrame();
        doctorListFrame.setTitle("Doctors at " + hospitalName);
        doctorListFrame.setSize(650, 300);
        doctorListFrame.setLayout(new GridLayout(5,4,3,3));
        doctorListFrame.setResizable(false);
        doctorListFrame.setLocationRelativeTo(null); 
         
        JLabel label = new JLabel("Doctors:");
        label.setFont(label.getFont().deriveFont(Font.BOLD, 14)); // Set font to bold and size 14
       
        doctorListFrame.add(label);

        if (hospitalName.equals("Quaid e Azam International Hospital")) {
            JButton doctor1Button = new JButton("Dr Usman (Orthopedic)");
            doctor1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logic for "Dr Usman" button
                     // Logic for "Dr Usman" button
                    JFrame doctorDetailsFrame = new JFrame();
                    doctorDetailsFrame.setTitle("Dr Usman - Details");
                    doctorDetailsFrame.setSize(650, 300);
                    doctorDetailsFrame.setLayout(new GridLayout(4,3,3,3));
                    doctorDetailsFrame.setResizable(false);
                    doctorDetailsFrame.setLocationRelativeTo(null);
                    
                   
                    
                    JLabel pmcLabel = new JLabel(" PMC Verified");
                    pmcLabel.setForeground(Color.green);
                    doctorDetailsFrame.add(pmcLabel);

                    JLabel experienceLabel = new JLabel(" Experience: 10 years");
                    doctorDetailsFrame.add(experienceLabel);

                    JLabel qualificationLabel = new JLabel(" Qualifications: MBBS, FCPS, Gold Medalist");
                    doctorDetailsFrame.add(qualificationLabel);

                    JButton bookAppointmentButton = new JButton("Book Appointment");
                    bookAppointmentButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            generatedTime();
                            
//                            Select_doctor drUsman=new  Select_doctor("Quaid e Azam International Hospital","Dr Usman (Orthopedic)");
                            Select_doctor drUsman=new  Select_doctor("Quaid e Azam International Hospital","Dr Usman (Orthopedic)",Username);
                           
                        }
                    });
                    doctorDetailsFrame.add(bookAppointmentButton);

                    doctorDetailsFrame.setVisible(true);
                   
                    doctorListFrame.dispose();
                }
            });
            doctorListFrame.add(doctor1Button);

            JButton doctor2Button = new JButton("Dr Ayesha (Skin Specialist)");
            doctor2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logic for "Dr Ayesha" button
                    JFrame doctor2DetailsFrame = new JFrame();
                    doctor2DetailsFrame.setTitle("Dr Ayesha - Details");
                    doctor2DetailsFrame.setSize(650, 300);
                    doctor2DetailsFrame.setLayout(new GridLayout(4,3,3,3));
                    doctor2DetailsFrame.setResizable(false);
                    doctor2DetailsFrame.setLocationRelativeTo(null);
                    
                    JLabel pmcLabel = new JLabel(" PMC Verified");
                    pmcLabel.setForeground(Color.green);
                    doctor2DetailsFrame.add(pmcLabel);

                    JLabel experienceLabel = new JLabel(" Experience: 6 years");
                    doctor2DetailsFrame.add(experienceLabel);

                    JLabel qualificationLabel = new JLabel(" Qualifications: MBBS, FCPS from UK medical college, Gold Medalist");
                    doctor2DetailsFrame.add(qualificationLabel);

                    JButton bookAppointmentButton = new JButton("Book Appointment");
                    bookAppointmentButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            generatedTime();
                           Select_doctor drAyesha=new  Select_doctor("Quaid e Azam International Hospital","Dr Ayesha (Skin Specialist)",Username);
                           doctor_appointments DA=new doctor_appointments();
                           
                        }
                    });
                    doctor2DetailsFrame.add(bookAppointmentButton);

                    doctor2DetailsFrame.setVisible(true);
                   
                    doctorListFrame.dispose();
                }
            });
            doctorListFrame.add(doctor2Button);

            JButton doctor3Button = new JButton("Dr Zia (General Surgeon)");
            doctor3Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logic for "Dr Zia" button
                    Frame doctorDetailsFrame = new JFrame();
                    doctorDetailsFrame.setTitle("Dr Zia - Details");
                    doctorDetailsFrame.setSize(650, 300);
                    doctorDetailsFrame.setLayout(new GridLayout(4,3,3,3));
                    doctorDetailsFrame.setResizable(false);
                    doctorDetailsFrame.setLocationRelativeTo(null);
                    
                    JLabel pmcLabel = new JLabel(" PMC Verified");
                    pmcLabel.setForeground(Color.green);
                    doctorDetailsFrame.add(pmcLabel);

                    JLabel experienceLabel = new JLabel(" Experience: 8 years");
                    doctorDetailsFrame.add(experienceLabel);

                    JLabel qualificationLabel = new JLabel(" Qualifications: MBBS from  Wah Medical College, FCPs in Surgery");
                    doctorDetailsFrame.add(qualificationLabel);

                    JButton bookAppointmentButton = new JButton("Book Appointment");
                    bookAppointmentButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            generatedTime();
                            Select_doctor drZia =new Select_doctor("Quaid e Azam International Hospital","Dr Zia (General Surgeon)",Username);
                            doctor_appointments DA=new doctor_appointments();
                          
                        }
                    });
                    doctorDetailsFrame.add(bookAppointmentButton);

                    doctorDetailsFrame.setVisible(true);
                    
                    doctorListFrame.dispose();
                }
            });
            doctorListFrame.add(doctor3Button);

            JButton doctor4Button = new JButton("Dr Safdar (Dental)");
            doctor4Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logic for "Dr Safdar" button
                    Frame doctorDetailsFrame = new JFrame();
                    doctorDetailsFrame.setTitle("Dr Safdar - Details");
                    doctorDetailsFrame.setSize(650, 300);
                    doctorDetailsFrame.setLayout(new GridLayout(4,3,3,3));
                    doctorDetailsFrame.setResizable(false);
                    doctorDetailsFrame.setLocationRelativeTo(null);
                    
                    JLabel pmcLabel = new JLabel(" PMC Verified");
                    pmcLabel.setForeground(Color.green);
                    doctorDetailsFrame.add(pmcLabel);

                    JLabel experienceLabel = new JLabel(" Experience: 5 years");
                    doctorDetailsFrame.add(experienceLabel);

                    JLabel qualificationLabel = new JLabel(" Qualifications: MBBS from China ");
                    doctorDetailsFrame.add(qualificationLabel);

                    JButton bookAppointmentButton = new JButton("Book Appointment");
                    bookAppointmentButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            generatedTime();
                           Select_doctor drSafdar =new Select_doctor("Quaid e Azam International Hospital"," Dr Safdar (Dental)",Username);
                           doctor_appointments DA=new doctor_appointments();
                          
                        }
                    });
                    doctorDetailsFrame.add(bookAppointmentButton);

                    doctorDetailsFrame.setVisible(true);
                   
                    doctorListFrame.dispose();
                }
            });
            doctorListFrame.add(doctor4Button);
        } else if (hospitalName.equals("Agha Khan Hospital")) {
            JButton doctor1Button = new JButton("Dr Nabeel (General Physician)");
            doctor1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logic for "Dr Nabeel" button
//                    JOptionPane.showMessageDialog(null, "Selected Dr Nabeel (General Physician)");
                    doctorListFrame.dispose();
                     Frame doctorDetailsFrame = new JFrame();
                    doctorDetailsFrame.setTitle("Dr Nabeel - Details");
                    doctorDetailsFrame.setSize(650, 300);
                    doctorDetailsFrame.setLayout(new GridLayout(4,3,3,3));
                    doctorDetailsFrame.setResizable(false);
                    doctorDetailsFrame.setLocationRelativeTo(null);
                    
                    JLabel pmcLabel = new JLabel(" PMC Verified");
                    pmcLabel.setForeground(Color.green);
                    doctorDetailsFrame.add(pmcLabel);

                    JLabel experienceLabel = new JLabel(" Experience: 11 years");
                    doctorDetailsFrame.add(experienceLabel);

                    JLabel qualificationLabel = new JLabel(" Qualifications: MBBS from KE");
                    doctorDetailsFrame.add(qualificationLabel);
                    
                    JButton bookAppointmentButton = new JButton("Book Appointment");
                    bookAppointmentButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            generatedTime();
                           Select_doctor drUsman=new Select_doctor("Agha Khan Hospital"," Dr Nabeel (General Physician)",Username);
                           doctor_appointments DA=new doctor_appointments();
                          
                        }
                    });
                    doctorDetailsFrame.add(bookAppointmentButton);

                    doctorDetailsFrame.setVisible(true);
                    
                    doctorListFrame.dispose();
                }
                
            });
            doctorListFrame.add(doctor1Button);

            JButton doctor2Button = new JButton("Dr Ahmad Raza (Cardiologist)");
            doctor2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logic for "Dr Ahmad Raza" button
//                    JOptionPane.showMessageDialog(null, "Selected Dr Ahmad Raza (Cardiologist)");
                    doctorListFrame.dispose();
                     Frame doctorDetailsFrame = new JFrame();
                    doctorDetailsFrame.setTitle("Dr Ahmad Raza - Details");
                    doctorDetailsFrame.setSize(650, 300);
                    doctorDetailsFrame.setLayout(new GridLayout(4,3,3,3));
                    doctorDetailsFrame.setResizable(false);
                    doctorDetailsFrame.setLocationRelativeTo(null);
                    
                    JLabel pmcLabel = new JLabel(" PMC Verified");
                    pmcLabel.setForeground(Color.green);
                    doctorDetailsFrame.add(pmcLabel);

                    JLabel experienceLabel = new JLabel(" Experience: 8 years");
                    doctorDetailsFrame.add(experienceLabel);

                    JLabel qualificationLabel = new JLabel(" Qualifications: MBBS from UK,Gold medalist ");
                    doctorDetailsFrame.add(qualificationLabel);
                    
                    JButton bookAppointmentButton = new JButton("Book Appointment");
                    bookAppointmentButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            generatedTime();
                            Select_doctor drAhmad=new Select_doctor("Agha Khan Hospital","Dr Ahmad Raza (Cardiologist)",Username);
                            doctor_appointments DA=new doctor_appointments();
                            
                        }
                    });
                    doctorDetailsFrame.add(bookAppointmentButton);

                    doctorDetailsFrame.setVisible(true);
                    
                    doctorListFrame.dispose();
                }
            });
            doctorListFrame.add(doctor2Button);

            JButton doctor3Button = new JButton("Dr Shahzaib (Psychiatrist)");
            doctor3Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logic for "Dr Shahzaib" button
//                    JOptionPane.showMessageDialog(null, "Selected Dr Shahzaib (Psychiatrist)");
                    doctorListFrame.dispose();
                     Frame doctorDetailsFrame = new JFrame();
                    doctorDetailsFrame.setTitle("Dr Shahzaib - Details");
                    doctorDetailsFrame.setSize(650, 300);
                    doctorDetailsFrame.setLayout(new GridLayout(4,3,3,3));
                    doctorDetailsFrame.setResizable(false);
                    doctorDetailsFrame.setLocationRelativeTo(null);
                    
                    JLabel pmcLabel = new JLabel(" PMC Verified");
                    pmcLabel.setForeground(Color.green);
                    doctorDetailsFrame.add(pmcLabel);

                    JLabel experienceLabel = new JLabel(" Experience: 9 years");
                    doctorDetailsFrame.add(experienceLabel);

                    JLabel qualificationLabel = new JLabel(" Qualifications: MBBS  ");
                    doctorDetailsFrame.add(qualificationLabel);
                    
                    JButton bookAppointmentButton = new JButton("Book Appointment");
                    bookAppointmentButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            generatedTime();
                          Select_doctor drShahzaib=new  Select_doctor("Agha Khan Hospital","Dr Shahzaib (Psychiatrist)",Username);
                          doctor_appointments DA=new doctor_appointments();
                          
                        }
                    });
                    doctorDetailsFrame.add(bookAppointmentButton);

                    doctorDetailsFrame.setVisible(true);
                    doctorListFrame.dispose();
                }
            });
            doctorListFrame.add(doctor3Button);
        }
        
        doctorListFrame.setVisible(true);
    }
    
    
    
 
   void  generatedTime(){
              int minHour = 8;
        int maxHour = 19;

        // Generate random hour and minute values
        int randomHour = ThreadLocalRandom.current().nextInt(minHour, maxHour + 1);
        int randomMinute = ThreadLocalRandom.current().nextInt(0, 60);

        // Determine if it's AM or PM
        String amPm;
        if (randomHour < 12) {
            amPm = "AM";
        } else {
            amPm = "PM";
        }

        // Convert hour to 12-hour format
        int displayHour;
        if (randomHour > 12) {
            displayHour = randomHour - 12;
        } else if (randomHour == 0) {
            displayHour = 12;
        } else {
            displayHour = randomHour;
        }

        // Format the time
        formattedTime = String.format("%02d:%02d %s", displayHour, randomMinute, amPm);
   }  

    
}





