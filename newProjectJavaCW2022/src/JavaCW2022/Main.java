//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//Date: 25/12/2022

package JavaCW2022;



import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static SkinConsultationManager westSkin = new WestminsterSkinConsultationManager();

        public static void main(String[] args){

            //-------------------------------Load File---------------------------------

            readSavedInfo();   // Load the past doctors from the text file
            readSavedPatientInfo(); // Load the past Patients from text file
            readSavedConsultationInfo(); // Load the past booked consultations from the text file


            System.out.println(WestminsterSkinConsultationManager.PatientList);
            System.out.println(WestminsterSkinConsultationManager.ConsultationList);


            menuLoop:
            while(true){
                displayMenu();
                System.out.print("Please Select What you would like to do: ");
                String choice = input.next();
                switch (choice) {
                    case "1":
                        AddNewDoctor();
                        break;
                    case "2":
                        DeleteDoctor();
                        break;
                    case "3":
                        printListDoctors();
                        break;
                    case "4":
                        SaveInFile();
                        break;
                    case "5":
                        System.out.println("GUI application is opened...");
                        new LaunchPage();
                        break;
                    case "6":
                        System.out.println("Thank You for using the system. Have a Pleasant Day !!");
                        break menuLoop;
                    default:
                        System.out.println("You've Selected Invalid Option . Please Try Again !!!");
                        break;
                }
        }
    }

    public static void displayMenu(){
        System.out.println(">>>>>>>>>>>>>>>>>>>!!!!! Welcome To Skin Consultation Centre !!!!!<<<<<<<<<<<<<<<<<");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(
                """
                        "1" :- Add a new doctor.
                        "2" :- Delete a doctor.
                        "3" :- Print the list of the doctors.
                        "4" :- Save in a file.
                        "5" :- Open GUI.
                        "6" :- Exit the program.
                        """
        );
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }


    private static void AddNewDoctor() {

            try {
                while(true) {
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Add a New Doctor<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

                    System.out.print("Enter doctors Name: ");
                    String fName = input.next().toUpperCase();

                    System.out.print("Enter doctors SurName: ");
                    String surName = input.next().toUpperCase();

                    System.out.print("Enter your Date of birth (YYYY/MM/DD): ");
                    String DOB = input.next();
                    LocalDate dateOfBirth = dateValidate(DOB);

                    System.out.print("Enter your mobile number: ");
                    String mobileNumber = input.next();

                    System.out.print("Enter your licence Number: ");
                    String licenceNumber = input.next();

                    // Doctor Available Date
                    System.out.print("Enter your Available Date : ");
                    String AvailableDocDate = input.next();
                    LocalDate AvailableDate = dateAvailableValidate(AvailableDocDate);

                    // Doctor Available Time
                    System.out.print("Enter Your Available Time: ");
                    String AvailableDocTime = input.next();
                    LocalTime AvailableTime = timeAvailableValidate(AvailableDocTime);



                    System.out.print("Enter your specialisation (cosmetic dermatology, medical dermatology, paediatric, dermatology): ");
                    String specialisation = input.next();


                    System.out.println("---------------------------------------------------");
                    System.out.println("Doctor's firstName      : " + fName);
                    System.out.println("Doctor's surName        : " + surName);
                    System.out.println("Doctor's dateOfBirth    : " + DOB);
                    System.out.println("Doctor's mobileNumber   : " + mobileNumber);
                    System.out.println("Doctor's licenceNumber  : " + licenceNumber);
                    System.out.println("Doctor's specialisation : " + specialisation);
                    System.out.println("Doctor's Available Date : " + AvailableDate);
                    System.out.println("Doctor's Available Time : " + AvailableTime);
                    System.out.println("---------------------------------------------------");
                    System.out.println();


                    Doctor NewDoctor = new Doctor(fName,surName,dateOfBirth,mobileNumber,licenceNumber,specialisation,AvailableDate,AvailableTime);
                    westSkin.AddNewDoctor(NewDoctor);

                    break;
                }
            }
            catch (Exception e){
                System.out.println("Invalid Date or Time Please enter again");
                System.out.println(e.getMessage());
                return;
            }
    }

    private static LocalDate dateValidate(String DOB){
        LocalDate dateOfBirth = LocalDate.parse(DOB, DateTimeFormatter.ISO_DATE);
        return dateOfBirth;
    }

    private static LocalDate dateAvailableValidate(String AvailableDocDate){
        LocalDate AvailableDate = LocalDate.parse(AvailableDocDate, DateTimeFormatter.ISO_DATE);
        return AvailableDate;
    }

    private static LocalTime timeAvailableValidate(String AvailableDocTime){
            LocalTime AvailableTime = LocalTime.parse(AvailableDocTime,DateTimeFormatter.ISO_TIME);
            return AvailableTime;
    }
    private static void DeleteDoctor(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Delete a Doctor<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        try {
            System.out.print("Please enter the licenceNumber of the doctor you want to remove: ");
            String licenceIDNumber = input.next();

            westSkin.DeleteDoctor(licenceIDNumber);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void printListDoctors(){
        westSkin.PrintDoctorList();
    }

    private static void SaveInFile(){
            westSkin.SaveDoctorFile();
    }
    private static void readSavedInfo() {
            westSkin.readSavedInfo();
    }

    private static void readSavedPatientInfo(){Add_Consultation.readSavedPatientInfo();}


    private static void readSavedConsultationInfo(){Add_Consultation.readSavedConsultationInfo();}
}
