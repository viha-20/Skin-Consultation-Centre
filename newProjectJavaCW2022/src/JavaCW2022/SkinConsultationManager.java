//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//Date: 25/12/2022
package JavaCW2022;



public interface SkinConsultationManager {

    void AddNewDoctor(Doctor doctor);
    void DeleteDoctor(String licenceNumber);
    void PrintDoctorList();



    void SaveDoctorFile();


    void readSavedInfo();
}
