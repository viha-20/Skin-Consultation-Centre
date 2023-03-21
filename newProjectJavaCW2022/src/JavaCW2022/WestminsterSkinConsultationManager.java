//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//Date: 25/12/2022


package JavaCW2022;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;


public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public  static ArrayList<Doctor> DoctorList = new ArrayList<>(10);
    public static ArrayList<Consultation> ConsultationList = new ArrayList<>();  // Booked Consultation list
    public static ArrayList<String> LicenceCheckList = new ArrayList<>();    // To check the doctors if doctor is booked  (Included only doctor licence number)

    public static ArrayList<Patient> PatientList = new ArrayList<>();    // patient list
    public static ArrayList<Consultation> PastBookedConsultationList = new ArrayList<>();
    private int availableSlots = 10;
    public  final int MAX_DOC_COUNT = 10;


    @Override
    public  void AddNewDoctor(Doctor NewDoctor) {

        for(Doctor doctor: DoctorList){
            if (doctor.equals(NewDoctor)){
                System.out.println("This Doctor is already in the list");
                return;
            }
        }
        if (DoctorList.size()<MAX_DOC_COUNT){
                DoctorList.add(NewDoctor);
                availableSlots -=1;
                System.out.println();
                System.out.println("A Doctor has been  successfully  added");
                System.out.println("Available Doctors slots remaining: " + availableSlots );

                LicenceCheckList.add(NewDoctor.getLicenceNumber());


        }
        else {
            System.out.println("--------------------------------------------------");
            System.out.println("The Doctor list is already full now");
            System.out.println("--------------------------------------------------");
        }
    }


    @Override
    public void DeleteDoctor(String licenceIDNumber) {   // Delete a Doctor using Medical Licence Number


        for (int i = 0; i < DoctorList.size(); i++) {
            if (DoctorList.get(i).getLicenceNumber().equals(licenceIDNumber)) {
                System.out.println("The information of the deleted doctor: " + DoctorList.get(i).getFname());     //Printing the deleted doctor's info
                DoctorList.remove(i);

                System.out.println("The doctor has been successfully deleted.Remaining doctors: ");   //Printing available slots after a doctor has  been deleted

                return;
            }

        }
        System.err.println("Invalid license number!.Please check and try again.");



        for (String doctor1:LicenceCheckList){                 // Remove the doctor licence number from the licenceChecklist as well
            if (doctor1==licenceIDNumber){
                LicenceCheckList.remove(licenceIDNumber);
                break;
            }
        }

    }

    @Override
    public void PrintDoctorList() {

        System.out.println("---------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>View all Doctors<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        DoctorList.sort(new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return
                        o1.getSurName().compareTo(o2.getSurName());
            }
        });



        if (this.DoctorList.isEmpty()){
            System.out.println("No Doctors in the list at the moment !!");
        }
        for (int i=0;i<DoctorList.size();i++){
            System.out.println(
                    "Doctor " + (i+1) + (":- ") + (DoctorList.get(i).getFname()) + " " + (DoctorList.get(i).getSurName())
                            +" " + (DoctorList.get(i).getDateOfBirth()) +" "+(DoctorList.get(i).getMobileNumber())
                            + " " + (DoctorList.get(i).getLicenceNumber()) + " " + (DoctorList.get(i).getSpecialisation()
                            + " " + (DoctorList.get(i).getAvailableDate())) + " " + (DoctorList.get(i).getAvailableTime())
            );
        }
    }


    public void readSavedInfo() {
        File file = new File("saveDoctor.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int docCount = Integer.parseInt(reader.readLine());
            for (int i=0; docCount>i; i++){
                String fName = (reader.readLine());
                String surName = (reader.readLine());
                LocalDate date = LocalDate.parse(reader.readLine());


                String mobileNumber = (reader.readLine());
                String licenceNumber =(reader.readLine());
                String specialisation =(reader.readLine());
                LocalDate Availabledate = LocalDate.parse(reader.readLine());
                LocalTime Availabletime = LocalTime.parse(reader.readLine());


                LicenceCheckList.add(licenceNumber);


                Doctor doctor = new Doctor(fName, surName,date,mobileNumber,licenceNumber,specialisation,Availabledate,Availabletime);
                DoctorList.add(doctor);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


        @Override
    public void SaveDoctorFile() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Store Program File<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        int docCount = DoctorList.size();


        try {
            FileWriter saveDoctor = new FileWriter("saveDoctor.txt");

            saveDoctor.write(String.valueOf(docCount));
            saveDoctor.write("\n");

            for (int i=0;i<DoctorList.size();i++){

              saveDoctor.write(DoctorList.get(i).getFname()) ;
              saveDoctor.write("\n");

              saveDoctor.write(DoctorList.get(i).getSurName()) ;
              saveDoctor.write("\n");

              saveDoctor.write(String.valueOf(DoctorList.get(i).getDateOfBirth()));
              saveDoctor.write("\n");

              saveDoctor.write(DoctorList.get(i).getMobileNumber()) ;
              saveDoctor.write("\n");

              saveDoctor.write(DoctorList.get(i).getLicenceNumber()) ;
              saveDoctor.write("\n");

              saveDoctor.write(DoctorList.get(i).getSpecialisation()) ;
              saveDoctor.write("\n");

              saveDoctor.write(String.valueOf(DoctorList.get(i).getAvailableDate()));
              saveDoctor.write("\n");

              saveDoctor.write(String.valueOf(DoctorList.get(i).getAvailableTime()));
              saveDoctor.write("\n");

            }


            saveDoctor.close();
            System.out.println();
            System.out.println("Doctors' List saved successfully in to the file......");
            System.out.println();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            System.out.println("File Doesn't Exist");
        }
    }
}
