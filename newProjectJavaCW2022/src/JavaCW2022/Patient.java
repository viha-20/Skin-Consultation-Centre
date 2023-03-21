//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//Date: 25/12/2022

package JavaCW2022;
import java.time.LocalDate;

public class Patient extends Person {

    public String patientID;

    public Patient(String fname, String surName, LocalDate dateOfBirth, String mobileNumber, String patientID) {
        super(fname, surName, dateOfBirth, mobileNumber);
        this.patientID = patientID;
    }


    public String getPatientID() {
        return this.patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "Patient{}" + super.toString();
    }
}
