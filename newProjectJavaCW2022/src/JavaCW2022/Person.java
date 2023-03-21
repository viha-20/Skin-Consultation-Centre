package JavaCW2022;
import java.time.LocalDate;

//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//Date: 25/12/2022


public class Person {
    public  String fname;
    public  String surName;
    public  LocalDate dateOfBirth;
    public String mobileNumber;


    public Person(String fname, String surName, LocalDate dateOfBirth, String mobileNumber) {
        this.fname = fname;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    public String getSurName() {
        return this.surName;
    }

    public  void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFname() {
        return this.fname;
    }

    public void setName(String name) {
        this.fname = name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fname'" + fname + '\''+
                ", surname='" + surName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mobileNumber='" + mobileNumber + '\''+
                '}';
    }
}
