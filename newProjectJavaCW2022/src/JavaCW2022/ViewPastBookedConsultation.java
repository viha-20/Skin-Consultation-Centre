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

public class ViewPastBookedConsultation extends JFrame implements ActionListener {

    JButton goBack = new JButton("Go Back");
    JFrame frame = new JFrame("View Past Booked Consultations");
    DefaultTableModel model = new DefaultTableModel();

    public ViewPastBookedConsultation(){

        // Create a table model

        JPanel panel = new JPanel();

        Border border = BorderFactory.createLineBorder(Color.black,5);

        model.addColumn("FirstName");
        model.addColumn("SurName");
        model.addColumn("DateOfBirth");
        model.addColumn("MobileNumber");
        model.addColumn("ConsultDate");
        model.addColumn("ConsultTime");
        model.addColumn("Per-hour Cost");
        model.addColumn("Notes");
        model.addColumn("Doc-MedicalNumber");


        // Add the data from the Arraylist to the table

        for (Consultation consultation:WestminsterSkinConsultationManager.PastBookedConsultationList){
            model.addRow(new Object[]{consultation.getFname(),consultation.getSurName(),consultation.getDateOfBirth(),
                    consultation.getMobileNumber(),consultation.getConsultDate(),consultation.getConsultTime(),
                    consultation.getCost(),consultation.getNotes(),consultation.getMedLicenceNum()});


        }

        JTable table = new JTable(model);
        table.setBounds(30,40,400,300);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800,400));

        panel.add(scrollPane);
        panel.setBorder(border);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(1000,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.lightGray);
        frame.pack();
        frame.setVisible(true);


        // Go Back To LaunchPage

        goBack.setPreferredSize(new Dimension(100,50));
        goBack.setBackground(new Color(100,150,200));
        goBack.setFocusable(false);
        goBack.addActionListener(this);
        goBack.setBorder(BorderFactory.createEtchedBorder());

        panel.add(goBack);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==goBack){
            frame.dispose();
            new LaunchPage();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }
}
