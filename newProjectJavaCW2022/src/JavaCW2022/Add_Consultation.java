package JavaCW2022;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Add_Consultation extends JFrame implements ActionListener {

    JButton Book,Back,Select;
    JTextField FName,SName,DBirth,MobileNum,LicenceNum,PatientId,ConsultTime,ConsultDate,Upload;
    JTextArea Note;


    public Add_Consultation(){
        JPanel jPanel = new JPanel();
        add(jPanel);


        JLabel firstName = new JLabel("First Name",SwingConstants.LEFT);
        JLabel surName = new JLabel("Sur Name",SwingConstants.LEFT);
        JLabel dateOfBirth = new JLabel("Date of Birth",SwingConstants.LEFT);
        JLabel licenceNum = new JLabel("Licence Number",SwingConstants.LEFT);
        JLabel mobileNUm = new JLabel("Mobile Number",SwingConstants.LEFT);
        JLabel patientId = new JLabel("Patient ID",SwingConstants.LEFT);
        JLabel consultDate = new JLabel("Consultation Date",SwingConstants.LEFT);
        JLabel consultTime = new JLabel("Consultation Time",SwingConstants.LEFT);
        JLabel note = new JLabel("Note",SwingConstants.LEFT);
        JLabel upload = new JLabel("Upload",SwingConstants.LEFT);


        Book = new JButton("Submit");
        Back = new JButton("Back");
        Select = new JButton("Select");
        Book.addActionListener(this);
        Select.addActionListener(this);
        Back.addActionListener(this);



        FName = new JTextField(10);
        SName = new JTextField(10);
        DBirth = new JTextField(10);
        LicenceNum = new JTextField(10);
        MobileNum = new JTextField(10);
        PatientId = new JTextField(10);
        ConsultDate = new JTextField(10);
        ConsultTime = new JTextField(10);
        Note = new JTextArea(5,6);
        Upload = new JTextField(10);



        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc =new GridBagConstraints();

        gc.fill=GridBagConstraints.HORIZONTAL;

        // Add Label
        gc.insets = new Insets(50,11,11,0);
        gc.gridx=0;
        gc.gridy=0;
        jPanel.add(firstName,gc);

        gc.insets = new Insets(0,11,11,0);
        gc.gridx=0;
        gc.gridy=1;
        jPanel.add(surName,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        jPanel.add(dateOfBirth,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        jPanel.add(licenceNum,gc);

        gc.gridx = 0;
        gc.gridy = 4;
        jPanel.add(mobileNUm,gc);

        gc.gridx = 0;
        gc.gridy = 5;
        jPanel.add(patientId,gc);

        gc.gridx = 0;
        gc.gridy = 6;
        jPanel.add(consultDate,gc);

        gc.gridx = 0;
        gc.gridy = 7;
        jPanel.add(consultTime,gc);

        gc.gridx = 0;
        gc.gridy = 8;
        jPanel.add(note,gc);

        gc.gridx = 0;
        gc.gridy = 10;
        jPanel.add(upload,gc);

        // Add Text field

        gc.insets = new Insets(50,11,11,20);
        System.out.println(gc.ipady);
        gc.gridx=1;
        gc.gridy=0;
        jPanel.add(FName,gc);

        gc.insets = new Insets(0,11,11,20);
        gc.gridx=1;
        gc.gridy=1;
        jPanel.add(SName,gc);

        gc.gridx=1;
        gc.gridy=2;
        jPanel.add(DBirth,gc);

        gc.gridx=1;
        gc.gridy=3;
        jPanel.add(LicenceNum,gc);

        gc.gridx=1;
        gc.gridy=4;
        jPanel.add(MobileNum,gc);

        gc.gridx=1;
        gc.gridy=5;
        jPanel.add(PatientId,gc);

        gc.gridx=1;
        gc.gridy=6;
        jPanel.add(ConsultDate,gc);

        gc.gridx=1;
        gc.gridy=7;
        jPanel.add(ConsultTime,gc);

        gc.gridx=1;
        gc.gridy=8;
        jPanel.add(Note,gc);

        gc.gridx = 1;
        gc.gridy = 10;
        jPanel.add(Select,gc);


        // Add Button

        gc.insets = new Insets(10,11,11,10);
        gc.gridx=0;
        gc.gridy=30;
        jPanel.add(Book,gc);

        gc.insets = new Insets(10,150,11,20);
        gc.gridx=1;
        gc.gridy=30;
        jPanel.add(Back,gc);

        pack();
        setVisible(true);
        jPanel.setBackground(Color.lightGray);



    }

    public void saveDetails(){

        try {
            String firstName = "";
            String surName = "";
            String dob = "";
            String mobileNumber = "";
            String licenceNumber = "";
            String patientId = "";
            String consultDate = "";
            String consultTime = "";

            boolean isEmpty = false;

            if (FName.getText().equals("")) {
                firstName = "First Name";
                isEmpty = true;
            }
            if (SName.getText().equals("")) {
                surName = "Sur Name";
                isEmpty = true;
            }
            if (DBirth.getText().equals("")) {
                dob = "Date of Birth";
                isEmpty = true;
            }
            if (MobileNum.getText().equals("")) {
                mobileNumber = "Mobile Number";
                isEmpty = true;
            }
            if (LicenceNum.getText().equals("")) {
                licenceNumber = "Licence Number";
                isEmpty = true;
            }
            if (PatientId.getText().equals("")) {
                patientId = "Patient ID";
                isEmpty = true;
            }
            if (ConsultDate.getText().equals("")) {
                consultDate = "Consultant Date";
                isEmpty = true;
            }
            if (ConsultTime.getText().equals("")) {
                consultTime = "Consultant Time";
                isEmpty = true;
            }
            if (isEmpty) {
                JOptionPane.showMessageDialog(null, "Please Enter following Fields:-" +
                        "\n" + firstName + "\n" + surName + "\n" + dob + "\n" + mobileNumber + "\n" +
                        licenceNumber + "\n" + patientId + "\n" + consultDate + "\n" +
                        consultTime + "\n");
            }
        }
        catch (Exception er){
            System.out.println(er.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==Back){
            this.dispose();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            new LaunchPage();

        }
        else if (e.getSource()==Book) {

            try {
                new ViewDoctorTable();
                saveDetails();

                String firstname = FName.getText().toUpperCase();
                String surname = SName.getText().toUpperCase();
                String dateOfBirth = DBirth.getText();
                String mobileNum = MobileNum.getText();
                String licenceNum = LicenceNum.getText();
                String patientId = PatientId.getText();
                String consultDate = ConsultDate.getText();
                String consultTime = ConsultTime.getText();
                String note = Note.getText();


                for (Doctor doctor : WestminsterSkinConsultationManager.DoctorList) {
                    for (String lice : WestminsterSkinConsultationManager.LicenceCheckList) {
                        if (doctor.getLicenceNumber().contains(lice) && lice.contains(licenceNum) && doctor.getAvailableDate().equals(LocalDate.parse(consultDate)) && doctor.getAvailableTime().equals(LocalTime.parse(consultTime))) {

                            WestminsterSkinConsultationManager.LicenceCheckList.remove(lice); // remove the doctor from the list for the consultation

                            //***************************************15 Only For the First Hour *******************************************

                            boolean containsDef = false;

                            for (Patient patient : WestminsterSkinConsultationManager.PatientList) {
                                if (patient.getPatientID().contains(patientId)) {
                                    containsDef = true;
                                    break;
                                }
                                break;
                            }
                            if (containsDef) {
                                double cost1 = 25;
                                // New patient
                                Patient newPatient = new Patient(firstname, surname, LocalDate.parse(dateOfBirth), mobileNum, patientId);
                                WestminsterSkinConsultationManager.PatientList.add(newPatient);

                                // New Consultation
                                Consultation consultation = new Consultation(firstname, surname, LocalDate.parse(dateOfBirth), mobileNum, LocalDate.parse(consultDate), LocalTime.parse(consultTime), cost1, note, licenceNum);
                                WestminsterSkinConsultationManager.ConsultationList.add(consultation);
                                JOptionPane.showMessageDialog(null, "Consultation Added Successfully");

                                this.dispose();
                                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                new ViewConsultation();

                                System.out.println(WestminsterSkinConsultationManager.PatientList);
                                System.out.println(WestminsterSkinConsultationManager.ConsultationList);

                            } else {
                                double cost0 = 15;
                                // New patient
                                Patient newPatient = new Patient(firstname, surname, LocalDate.parse(dateOfBirth), mobileNum, patientId);
                                WestminsterSkinConsultationManager.PatientList.add(newPatient);

                                // New Consultation
                                Consultation consultation = new Consultation(firstname, surname, LocalDate.parse(dateOfBirth), mobileNum, LocalDate.parse(consultDate), LocalTime.parse(consultTime), cost0, note, licenceNum);
                                WestminsterSkinConsultationManager.ConsultationList.add(consultation);
                                JOptionPane.showMessageDialog(null, "Consultation Added Successfully");

                                this.dispose();
                                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                new ViewConsultation();

                            }


                            //*****************************************************************************************************************


                        }  // If LicenceCheckList not include the medical licence number patient allocated to  another doctor
                        else {
                            JOptionPane.showMessageDialog(null, "Your Doctor is already Booked & You allocated to another doctor !");
                            String medLicence = "";
                            for (String nextlice : WestminsterSkinConsultationManager.LicenceCheckList) {
                                if (!Objects.equals(nextlice, lice)) {
                                    medLicence = nextlice;
                                    break;
                                }
                                System.out.println("");
                            }
                            WestminsterSkinConsultationManager.LicenceCheckList.remove(medLicence);

                            //***************************************15 Only For the First Hour *******************************************

                            boolean containsDef = false;

                            for (Patient patient : WestminsterSkinConsultationManager.PatientList) {
                                if (patient.getPatientID().contains(patientId)) {
                                    containsDef = true;
                                    break;
                                }
                                break;
                            }

                            if (containsDef) {
                                double cost1 = 25;
                                // New patient
                                Patient newPatient = new Patient(firstname, surname, LocalDate.parse(dateOfBirth), mobileNum, patientId);
                                WestminsterSkinConsultationManager.PatientList.add(newPatient);

                                // New Consultation
                                Consultation consultation = new Consultation(firstname, surname, LocalDate.parse(dateOfBirth), mobileNum, LocalDate.parse(consultDate), LocalTime.parse(consultTime), cost1, note, medLicence);
                                WestminsterSkinConsultationManager.ConsultationList.add(consultation);
                                JOptionPane.showMessageDialog(null, "Consultation Added Successfully");

                                this.dispose();
                                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                new ViewConsultation();

                                System.out.println(WestminsterSkinConsultationManager.PatientList);
                                System.out.println(WestminsterSkinConsultationManager.ConsultationList);

                            } else {
                                double cost0 = 15;
                                // New patient
                                Patient newPatient = new Patient(firstname, surname, LocalDate.parse(dateOfBirth), mobileNum, patientId);
                                WestminsterSkinConsultationManager.PatientList.add(newPatient);

                                // New Consultation
                                Consultation consultation = new Consultation(firstname, surname, LocalDate.parse(dateOfBirth), mobileNum, LocalDate.parse(consultDate), LocalTime.parse(consultTime), cost0, note, licenceNum);
                                WestminsterSkinConsultationManager.ConsultationList.add(consultation);
                                JOptionPane.showMessageDialog(null, "Consultation Added Successfully");

                                this.dispose();
                                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                new ViewConsultation();

                            }
                            //**************************************************************************************
                        }
                        break;
                    }
                    break;
                }
            }
            catch (Exception ej){
                System.err.println("Please enter valid inputs !");
            }
        }


        // Add Image

        else if(e.getSource()==Select){

            JFileChooser fileChooser = new JFileChooser();
            //fileChooser.addChoosableFileFilter(new ImageFilter());
            fileChooser.setAcceptAllFileFilterUsed(false);

            int option = fileChooser.showOpenDialog(null);
            if (option == JFileChooser.APPROVE_OPTION){
                File file =fileChooser.getSelectedFile();
                String filePath = file.getAbsolutePath();
                //filePathEncrypt = encryption.encrypt(filePath,secretKey);

               // Use the selected file to create an ImageIcon

                ImageIcon icon = new ImageIcon(file.getAbsolutePath());

            }
            else{
                System.out.println("No file selected");
            }

        }


        // ********************************Save The Patient details To the file****************************************

        int patientCount = WestminsterSkinConsultationManager.PatientList.size();

        try {
            FileWriter savePatient = new FileWriter("savePatient.txt");

            savePatient.write(String.valueOf(patientCount));
            savePatient.write("\n");

            for (int i =0;i<WestminsterSkinConsultationManager.PatientList.size();i++){

                savePatient.write(WestminsterSkinConsultationManager.PatientList.get(i).getFname());
                savePatient.write("\n");

                savePatient.write(WestminsterSkinConsultationManager.PatientList.get(i).getSurName());
                savePatient.write("\n");

                savePatient.write(String.valueOf(WestminsterSkinConsultationManager.PatientList.get(i).getDateOfBirth()));
                savePatient.write("\n");

                savePatient.write(WestminsterSkinConsultationManager.PatientList.get(i).getMobileNumber());
                savePatient.write("\n");

                savePatient.write(WestminsterSkinConsultationManager.PatientList.get(i).getPatientID());
                savePatient.write("\n");
            }

            savePatient.close();
            System.out.println();
            System.out.println("PatientsList saved successfully into the file ");
            System.out.println();

        }

        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //*************************************Save the Past Consultation Details to the file***************************

        int ConsultationCount = WestminsterSkinConsultationManager.ConsultationList.size();

        try {
            FileWriter saveConsultation = new FileWriter("savePastConsultation.txt");

            saveConsultation.write(String.valueOf(ConsultationCount));
            saveConsultation.write("\n");

            for (int i =0;i<WestminsterSkinConsultationManager.ConsultationList.size();i++){

                saveConsultation.write(WestminsterSkinConsultationManager.ConsultationList.get(i).getFname());
                saveConsultation.write("\n");

                saveConsultation.write(WestminsterSkinConsultationManager.ConsultationList.get(i).getSurName());
                saveConsultation.write("\n");

                saveConsultation.write(String.valueOf(WestminsterSkinConsultationManager.ConsultationList.get(i).getDateOfBirth()));
                saveConsultation.write("\n");

                saveConsultation.write(WestminsterSkinConsultationManager.ConsultationList.get(i).getMobileNumber());
                saveConsultation.write("\n");

                saveConsultation.write(String.valueOf(WestminsterSkinConsultationManager.ConsultationList.get(i).getConsultDate()));
                saveConsultation.write("\n");

                saveConsultation.write(String.valueOf(WestminsterSkinConsultationManager.ConsultationList.get(i).getConsultTime()));
                saveConsultation.write("\n");

                saveConsultation.write(String.valueOf(WestminsterSkinConsultationManager.ConsultationList.get(i).getCost()));
                saveConsultation.write("\n");

                saveConsultation.write(WestminsterSkinConsultationManager.ConsultationList.get(i).getNotes());
                saveConsultation.write("\n");

                saveConsultation.write(WestminsterSkinConsultationManager.ConsultationList.get(i).getMedLicenceNum());
                saveConsultation.write("\n");

            }

            saveConsultation.close();
            System.out.println();
            System.out.println("PatientsList saved successfully into the file ");
            System.out.println();

        }

        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    public static void readSavedPatientInfo(){
        File filePatient = new File("savePatient.txt");

        try (BufferedReader readerPatient = new BufferedReader(new FileReader(filePatient))) {

            int patientCount = Integer.parseInt(readerPatient.readLine());
            for (int i = 0;patientCount>i;i++){
                String firstName = (readerPatient.readLine());
                String surName = (readerPatient.readLine());
                LocalDate dob = LocalDate.parse(readerPatient.readLine());

                String mobNumber = (readerPatient.readLine());
                String patientID = (readerPatient.readLine());

                Patient patient = new Patient(firstName,surName,dob,mobNumber,patientID);
                WestminsterSkinConsultationManager.PatientList.add(patient);

            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void readSavedConsultationInfo(){
        File fileConsultation = new File("savePastConsultation.txt");

        try (BufferedReader readerPastConsultation = new BufferedReader(new FileReader(fileConsultation))) {

            int consultationCountPast = Integer.parseInt(readerPastConsultation.readLine());

            for (int i = 0;consultationCountPast>i;i++){

                String firstName = (readerPastConsultation.readLine());
                String surName = (readerPastConsultation.readLine());
                LocalDate dob = LocalDate.parse(readerPastConsultation.readLine());

                String mobNumber = (readerPastConsultation.readLine());
                LocalDate consultdate = LocalDate.parse(readerPastConsultation.readLine());
                LocalTime consulttime = LocalTime.parse(readerPastConsultation.readLine());
                String cost = (readerPastConsultation.readLine());
                String notes = (readerPastConsultation.readLine());
                String medNum = (readerPastConsultation.readLine());

                Consultation pastConsult = new Consultation(firstName,surName,dob,mobNumber,consultdate,consulttime,Double.parseDouble(cost),notes,medNum);
                WestminsterSkinConsultationManager.PastBookedConsultationList.add(pastConsult);

            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
