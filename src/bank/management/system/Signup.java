package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3;
    JTextField textName , textMobile, textEmail,textAddress,textCity,textPin;

    JButton buttonNext;

    JDateChooser dateChooser;

    Random ran = new Random();

    long digit = (ran.nextLong()%9000L)+1000L;
    String first = " "+ Math.abs(digit);
    Signup(){
        super("APPLICATION FORM");

        ImageIcon bankimg = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image imgbank = bankimg.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(imgbank);
        JLabel image1 = new JLabel(i1);
        image1.setBounds(25,10,100,100);
        add(image1);

        JLabel label1 = new JLabel("APPLICATION FORM NO."+first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(290,100,600,30);
        add(label3);

        JLabel labelName = new JLabel(("Name:"));
        labelName.setFont(new Font("Raleway",Font.BOLD,15));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,190,300,30);
        add(textName);

        JLabel labelMobile = new JLabel("Registered Mobile No:");
        labelMobile.setFont(new Font("Raleway",Font.BOLD,15));
        labelMobile.setBounds(100,240,600,30);
        add(labelMobile);

        textMobile = new JTextField();
        textMobile.setFont(new Font("Raleway",Font.BOLD,14));
        textMobile.setBounds(300,240,300,30);
        add(textMobile);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setBounds(100,290,200,30);
        DOB.setFont(new Font("Raleway",Font.BOLD,15));
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,290,400,30);
        add(dateChooser);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setFont(new Font("Raleway",Font.BOLD,15));
        labelGender.setBounds(100,340,300,30);
        add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,12));
        r1.setBounds(300,340,60,30);
        r1.setBackground(new Color(222,255,228));

        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,12));
        r2.setBounds(400,340,70,30);
        r2.setBackground(new Color(222,255,228));

        add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Raleway",Font.BOLD,12));
        r3.setBounds(500,340,60,30);
        r3.setBackground(new Color(222,255,228));
        add(r3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        JLabel labelEmail = new JLabel("Email Address:");
        labelEmail.setBounds(100,390,300,30);
        labelEmail.setFont(new Font("Raleway",Font.BOLD,15));
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,15));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        JLabel labelAddress = new JLabel("Permanent Address:");
        labelAddress.setBounds(100,440,300,30);
        labelAddress.setFont(new Font("Raleway",Font.BOLD,15));
        add(labelAddress);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Raleway",Font.BOLD,15));
        textAddress.setBounds(300,440,400,100);
        add(textAddress);

        JLabel labelCity = new JLabel("City:");
        labelCity.setBounds(100,570,300,30);
        labelCity.setFont(new Font("Raleway",Font.BOLD,15));
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,15));
        textCity.setBounds(300,570,200,30);
        add(textCity);

        JLabel labelPin = new JLabel("Pincode:");
        labelPin.setBounds(100,620,300,30);
        labelPin.setFont(new Font("Raleway",Font.BOLD,15));
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD,15));
        textPin.setBounds(300,620,200,30);
        add(textPin);

        buttonNext = new JButton("Next");
        buttonNext.setFont(new Font("Raleway",Font.BOLD,14));
        buttonNext.setBackground(Color.BLACK);
        buttonNext.setForeground(Color.WHITE);
        buttonNext.setBounds(620,660,80,30);
        buttonNext.addActionListener(this);
        add(buttonNext);


        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText();
        String dob  = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String phno = textMobile.getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }
        else{
            gender = "Other";
        }
        String email = textEmail.getText();
        String address = textAddress.getText();

        String city = textCity.getText();
        String pin = textPin.getText();

        try{
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            else{
                Con con1 = new Con();
                String q = "insert into signup values('"+formno+"','"+name+"','"+phno+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+pin+"')";
                con1.statement.executeUpdate(q);

                new Signup2(formno);
                setVisible(false);


            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Signup();
    }
}
