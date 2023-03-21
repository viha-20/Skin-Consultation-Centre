//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//Date: 25/12/2022

package JavaCW2022;


import java.time.LocalDate;
import java.time.LocalTime;


public class Consultation extends Person {
    public LocalDate consultDate;
    public LocalTime consultTime;
    public  double cost;
    public String notes;

    public String medLicenceNum;


    public Consultation(String fname, String surName, LocalDate dateOfBirth, String mobileNumber, LocalDate consultDate, LocalTime consultTime,double cost, String notes,String medLicenceNum) {
        super(fname, surName, dateOfBirth, mobileNumber);
        this.consultDate = consultDate;
        this.consultTime = consultTime;
        this.cost = cost;
        this.notes = notes;
        this.medLicenceNum=medLicenceNum;
    }

    public LocalDate getConsultDate() {
        return this.consultDate;
    }

    public void setConsultDate(LocalDate consultDate) {
        this.consultDate = consultDate;
    }

    public LocalTime getConsultTime() {
        return this.consultTime;
    }

    public void setConsultTime(LocalTime consultTime) {
        this.consultTime = consultTime;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMedLicenceNum() {
        return medLicenceNum;
    }

    public void setMedLicenceNum(String medLicenceNum) {
        this.medLicenceNum = medLicenceNum;
    }
}
