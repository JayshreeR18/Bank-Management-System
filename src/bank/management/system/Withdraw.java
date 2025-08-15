package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    String password;
    JTextField textDeposit;
    JButton b1,b2;
    Withdraw(String password){
        this.password = password;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("Maximum Withdrawal is Rs.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Raleway",Font.BOLD,12));
        label1.setBounds(460,180,400,35);
        l3.add(label1);

        JLabel label2 = new JLabel("Enter Amount You Want To Withdraw");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Raleway",Font.BOLD,16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);

        textDeposit = new JTextField();
        textDeposit.setBounds(460,260,320,25);
        textDeposit.setBackground(new Color(65,125,128));
        textDeposit.setForeground(Color.WHITE);
        textDeposit.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textDeposit);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);




        setLayout(null);
        setSize(1550,1080);
        setLocation(00,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==b1) {


    try {
        String amount = textDeposit.getText();
        Date date = new Date();
        if (textDeposit.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter The Amount");
        } else {
            Con c1 = new Con();
            ResultSet resultSet = c1.statement.executeQuery("select * from deposit where pin = '" + password + "'");
            int balance = 0;
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            c1.statement.executeUpdate("insert into deposit values('" + password + "','" + date + "','Withdraw','" + amount + "')");
            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully.");
            setVisible(false);
            new main_Class(password);
        }


    } catch (Exception E) {
        E.printStackTrace();
    }
}else if(e.getSource()==b2){
    setVisible(false);
    new main_Class(password);
}

    }

    public static void main(String[] args) {
        new Withdraw("");

    }
}
