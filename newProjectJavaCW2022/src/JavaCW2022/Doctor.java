//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//Date: 25/12/2022

package JavaCW2022;

import java.time.LocalDate;
import java.time.LocalTime;

public class Doctor extends Person {
    public  String licenceNumber;
    public  String specialisation;
    public LocalDate AvailableDate;
    public LocalTime AvailableTime;

    public Doctor(String fname, String surName, LocalDate dateOfBirth, String mobileNumber, String licenceNumber, String specialisation,LocalDate AvailableDate,LocalTime AvailableTime) {
        super(fname, surName, dateOfBirth, mobileNumber);
        this.licenceNumber = licenceNumber;
        this.specialisation = specialisation;
        this.AvailableDate = AvailableDate;
        this.AvailableTime=AvailableTime;

    }


    public String getLicenceNumber() {
        return this.licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getSpecialisation() {
        return this.specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public LocalDate getAvailableDate() {
        return this.AvailableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.AvailableDate = availableDate;
    }

    public LocalTime getAvailableTime() {
        return this.AvailableTime;
    }

    public void setAvailableTime(LocalTime availableTime) {
        this.AvailableTime = availableTime;
    }

    @Override
    public String toString() {

        return "Doctor{" + super.toString() +
                ", licenceNumber='" + licenceNumber + '\''+
                ", specialisation='" + specialisation + '\''+
                ", AvailableDate='" + AvailableDate + '\''+
                ", AvailableTime='" + AvailableTime + '\''+
                '}';
    }
}
