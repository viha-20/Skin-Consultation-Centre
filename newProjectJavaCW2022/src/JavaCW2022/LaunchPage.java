package JavaCW2022;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LaunchPage extends WestminsterSkinConsultationManager implements ActionListener {
    JFrame frame = new JFrame("Skin Consultation Centre");
    JButton ViewButton = new JButton("View Doctors");
    JButton AddConsult = new JButton("Add Consultation");

    JButton ViewConsult = new JButton("View Consultation");

    JButton ViewPastConsultation = new JButton("Past View Booked Consultations");

    JButton Exit = new JButton("Exit");

    public LaunchPage(){

        // header

        JPanel header = new JPanel();
        header.setBackground(new Color(0,0,0,60));
        header.setBounds(0,0,900,100);
        JLabel title = new JLabel("WELCOME TO THE SKIN CONSULTATION CENTRE");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(Font.MONOSPACED,Font.BOLD,35));
        title.setBounds(200,50,400,50);
        header.add(title);


        // Add Consultation
        AddConsult.setBounds(70,130,200,40);   //330
        AddConsult.setBackground(new Color(100,150,200));
        AddConsult.setFocusable(false);
        AddConsult.addActionListener(this);
        AddConsult.setBorder(BorderFactory.createEtchedBorder());

        Border comp1 = new CompoundBorder(new LineBorder(Color.lightGray, 2, true), new LineBorder(Color.black, 3));
        AddConsult.setBorder(comp1);



        // View All Doctors

        ViewButton.setBounds(70,230,200,40);   //100
        ViewButton.setBackground(new Color(100,150,200));
        ViewButton.setFocusable(false);
        ViewButton.addActionListener(this);
        ViewButton.setBorder(BorderFactory.createEtchedBorder());
        ViewButton.setBorder(comp1);


        // View All Consultation

        ViewConsult.setBounds(620,130,200,40);   //550
        ViewConsult.setBackground(new Color(100,150,200));
        ViewConsult.setFocusable(false);
        ViewConsult.addActionListener(this);
        ViewConsult.setBorder(BorderFactory.createEtchedBorder());
        ViewConsult.setBorder(comp1);


        // View All Past Booked Consultation

        ViewPastConsultation.setBounds(620,230,200,40);
        ViewPastConsultation.setBackground(new Color(100,150,200));
        ViewPastConsultation.setFocusable(false);
        ViewPastConsultation.addActionListener(this);
        ViewPastConsultation.setBorder(BorderFactory.createEtchedBorder());
        ViewPastConsultation.setBorder(comp1);




        // Exit From the GUI

        Exit.setBounds(320,450,200,40);
        Exit.setBackground(new Color(223,70,97));
        Exit.setFocusable(false);
        Exit.addActionListener(this);
        Exit.setBorder(BorderFactory.createEtchedBorder());
        Exit.setBorder(comp1);



        // Frame
        frame.setSize(900,600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Adding background Image
        ImageIcon background_image = new ImageIcon("C:\\Users\\HP\\IdeaProjects\\newProjectJavaCW2022\\src\\JavaCW2022\\westSkin1.jpg");

        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_image,JLabel.CENTER);

        background.add(header);
        background.add(ViewButton);
        background.add(AddConsult);
        background.add(ViewConsult);
        background.add(ViewPastConsultation);
        background.add(Exit);


        background.setBounds(0,0,900,600);
        frame.add(background);
        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == ViewButton) {       // View All Doctors Button
                frame.dispose();
                new ViewDoctorTable();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
            else if (e.getSource() == AddConsult) {             // Add Consultation Button
                frame.dispose();
                new ViewDoctorTable();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                new Add_Consultation();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else if (e.getSource() == ViewConsult) {          // View Consultation Button
                frame.dispose();
                new ViewConsultation();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }

            else if(e.getSource()==ViewPastConsultation){    // View Past Booked Consultations
                frame.dispose();
                new ViewPastBookedConsultation();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }

            else if(e.getSource()==Exit){
                frame.dispose();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                new Main();
            }
        }
        catch (Exception ev){
            System.out.println(ev.getMessage());
        }


    }
}
