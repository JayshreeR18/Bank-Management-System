package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton button1, button2, button3;

    login(){
        super("Bank Management System");

        ImageIcon bankimg = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image imgbank = bankimg.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(imgbank);
        JLabel image1 = new JLabel(i1);
        image1.setBounds(350,10,100,100);
        add(image1);

        ImageIcon cardimg = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image imgcard = cardimg.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(imgcard);
        JLabel image2 = new JLabel(i2);
        image2.setBounds(630,350,100,100);
        add(image2);


        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,30));
        label1.setBounds(270,125,450,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial", Font.BOLD,14));
        add(textField2);



        label3 = new JLabel("Pin:");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);


        passwordField3 = new JPasswordField(15);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        passwordField3.setBounds(325,250,230,30);
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,15));
        button1.setBounds(300,300,100,30);
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.addActionListener(this);
        add(button1);


        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,15));
        button2.setBounds(430,300,100,30);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,15));
        button3.setBounds(300,350,230,30);
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.addActionListener(this);
        add(button3);



        ImageIcon bgimg = new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
        Image imgbg = bgimg.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(imgbg);
        JLabel image3 = new JLabel(i3);
        image3.setBounds(0,0,850,480);
        add(image3);

        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==button1){
                Con c1 = new Con();
                String cardno = textField2.getText();
                String password = passwordField3.getText();
                String q = "Select * from login where card_no = '"+cardno+"'and pin = '"+password+"'";
                ResultSet resultSet = c1.statement.executeQuery(q);

                if(resultSet.next()){
                    setVisible(false);
                    new main_Class(password);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Credentials");

                }

            } else if (e.getSource()==button2) {
                textField2.setText("");
                passwordField3.setText("");
            }else if (e.getSource()==button3){
                new Signup();
                setVisible(false);

            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args){
        new login();
    }
}
