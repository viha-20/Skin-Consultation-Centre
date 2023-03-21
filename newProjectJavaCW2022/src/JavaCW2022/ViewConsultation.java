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

public class ViewConsultation extends JFrame implements ActionListener {

    JButton goBack = new JButton("Go Back");
    JFrame ConsultFrame = new JFrame("Consultation");
    JPanel panel = new JPanel();
    DefaultTableModel tableModel = new DefaultTableModel();


    public ViewConsultation(){

        // Create a table model
        Border border = BorderFactory.createLineBorder(Color.black,5);


        tableModel.addColumn("PatientFName");
        tableModel.addColumn("PatientSurName");
        tableModel.addColumn("DateOfBirth");
        tableModel.addColumn("MobileNumber");
        tableModel.addColumn("ConsultDate");
        tableModel.addColumn("ConsultTime");
        tableModel.addColumn("Cost-Per-Hour");
        tableModel.addColumn("Notes");
        tableModel.addColumn("Doc-LicenceNumber");


        // Add the data from the Arraylist to the table model

        for (Consultation consultation:WestminsterSkinConsultationManager.ConsultationList){
            tableModel.addRow(new Object[]{
                    consultation.getFname(),
                    consultation.getSurName(),
                    consultation.getDateOfBirth(),
                    consultation.getMobileNumber(),
                    consultation.getConsultDate(),
                    consultation.getConsultTime(),
                    consultation.getCost(),
                    consultation.getNotes(),
                    consultation.getMedLicenceNum()});

        }


        JTable table = new JTable(tableModel);
        table.setBounds(30,40,500,300);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(990,400));

        panel.add(scrollPane);
        panel.setBorder(border);
        ConsultFrame.add(panel,BorderLayout.CENTER);


        ConsultFrame.setSize(1000,900);
        ConsultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ConsultFrame.setBackground(Color.lightGray);
        ConsultFrame.pack();
        ConsultFrame.setVisible(true);

        // Go Back To First View

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
            ConsultFrame.dispose();
            ConsultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            new LaunchPage();
        }

    }
}
