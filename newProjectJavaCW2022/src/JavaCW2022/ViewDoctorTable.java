//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//Date: 25/12/2022
package JavaCW2022;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;


public class ViewDoctorTable extends JFrame implements ActionListener  {

    JButton goBack = new JButton("Go Back");
    JFrame frame = new JFrame("View Doctors");

    JButton Sort = new JButton("Sort");

    DefaultTableModel model = new DefaultTableModel();


   public ViewDoctorTable(){

       // Create a table model

       JPanel panel1 = new JPanel();

       Border border = BorderFactory.createLineBorder(Color.black,5);



       model.addColumn("FirstName");
       model.addColumn("SurName");
       model.addColumn("DateOfBirth");
       model.addColumn("MobileNumber");
       model.addColumn("LicenceNumber");
       model.addColumn("AvailableDate");
       model.addColumn("AvailableTime");
       model.addColumn("Specialisation");


       // Add the data from the Arraylist to the table model

       for (Doctor doctor:WestminsterSkinConsultationManager.DoctorList){
           model.addRow(new Object[]{doctor.getFname(), doctor.getSurName(),doctor.getDateOfBirth(), doctor.getMobileNumber(),doctor.getLicenceNumber(),doctor.getAvailableDate(),doctor.getAvailableTime(),doctor.getSpecialisation()});
       }


       JTable table = new JTable(model);
       table.setBounds(30,40,400,300);
       JScrollPane scrollPane = new JScrollPane(table);
       scrollPane.setPreferredSize(new Dimension(800,400));

       panel1.add(scrollPane);
       panel1.setBorder(border);
       frame.add(panel1, BorderLayout.CENTER);

       frame.setSize(1000,900);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setBackground(Color.lightGray);
       frame.pack();
       frame.setVisible(true);


       // Go Back To First View

       //goBack.setBounds(330,450,150,30);
       goBack.setPreferredSize(new Dimension(100,50));
       goBack.setBackground(new Color(100,150,200));
       goBack.setFocusable(false);
       goBack.addActionListener(this);
       goBack.setBorder(BorderFactory.createEtchedBorder());


       // Sort
       //Sort.setBounds(70,200,200,40);
       Sort.setPreferredSize(new Dimension(100,50));
       Sort.setBackground(new Color(100,150,200));
       Sort.setFocusable(false);
       Sort.addActionListener(this);
       Sort.setBorder(BorderFactory.createEtchedBorder());

       panel1.add(Sort);
       panel1.add(goBack);
   }


    @Override
    public void actionPerformed(ActionEvent e) {

       if (e.getSource()==goBack){
           frame.dispose();
           new LaunchPage();
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
       else if(e.getSource()==Sort){

            // Sort the DocList field by the doctors first name
           Collections.sort(WestminsterSkinConsultationManager.DoctorList, new Comparator<Doctor>() {
               @Override
               public int compare(Doctor o1, Doctor o2) {
                   return o1.getFname().compareTo(o2.getFname());
               }
           });

           // Update the table with the sorted list
           model.setRowCount(0); // Clear the existing rows

           for (int i=0;i<WestminsterSkinConsultationManager.DoctorList.size();i++){
               model.addRow(new Object[]{
                               WestminsterSkinConsultationManager.DoctorList.get(i).getFname(),
                               WestminsterSkinConsultationManager.DoctorList.get(i).getSurName(),
                               WestminsterSkinConsultationManager.DoctorList.get(i).getDateOfBirth(),
                               WestminsterSkinConsultationManager.DoctorList.get(i).getMobileNumber(),
                               WestminsterSkinConsultationManager.DoctorList.get(i).getLicenceNumber(),
                               WestminsterSkinConsultationManager.DoctorList.get(i).getAvailableDate(),
                               WestminsterSkinConsultationManager.DoctorList.get(i).getAvailableTime(),
                               WestminsterSkinConsultationManager.DoctorList.get(i).getSpecialisation()
               });

           }
       }

   }
}
