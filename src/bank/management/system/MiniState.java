package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniState extends JFrame implements ActionListener {
    String password;
    JButton button;
    MiniState(String password){


        this.password = password;

        getContentPane().setBackground(new Color(255,204,204));
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);


        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2 = new JLabel();
        label2.setFont(new Font("Raleway",Font.BOLD,15));
        label2.setBounds(50,20,600,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,60,300,20);
        add(label3);


        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);


        try{

            Con c1 = new Con();
            ResultSet resultSet = c1.statement.executeQuery("select * from login where pin = '"+password+"'");
            while(resultSet.next()){
                label3.setText("Card Number: "+resultSet.getString("card_no").substring(0,4)+"-XXXX-XXXX-"+resultSet.getString("card_no").substring(12));
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            Con c1 = new Con();
            ResultSet resultSet = c1.statement.executeQuery("select * from signup");
            while(resultSet.next()){
                label2.setText("Accountant Name: "+resultSet.getString("name"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        try {

            int balance = 0;
            Con c1 = new Con();
            ResultSet resultSet = c1.statement.executeQuery("select * from deposit where pin = '" + password + "'");
            while (resultSet.next()) {
                label1.setText(label1.getText()+ "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            label4.setText("Your Total Balance is Rs "+balance);

        }catch(Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            setVisible(false);

    }

    public static void main(String[] args) {
        new MiniState("");
    }
}
