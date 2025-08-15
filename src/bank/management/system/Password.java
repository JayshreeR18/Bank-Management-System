package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password extends JFrame implements ActionListener {
    JButton b1,b2;
    String password;
    JPasswordField textPassword1,textPassword2;
    Password(String password){
        this.password = password;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);


        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Raleway",Font.BOLD,16));
        label1.setBounds(430,180,400,35);
        l3.add(label1);

        JLabel label2 = new JLabel("NEW PIN");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Raleway",Font.BOLD,16));
        label2.setBounds(430,220,400,35);
        l3.add(label2);


        textPassword1 = new JPasswordField();
        textPassword1.setBounds(430,250,200,25);
        textPassword1.setBackground(new Color(65,125,128));
        textPassword1.setForeground(Color.WHITE);
        textPassword1.setFont(new Font("Raleway",Font.BOLD,20));
        l3.add(textPassword1);

        JLabel label3 = new JLabel("Re-Enter NEW PIN");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Raleway",Font.BOLD,16));
        label3.setBounds(430,280,400,35);
        l3.add(label3);

        textPassword2 = new JPasswordField();
        textPassword2.setBounds(430,310,200,25);
        textPassword2.setBackground(new Color(65,125,128));
        textPassword2.setForeground(Color.WHITE);
        textPassword2.setFont(new Font("Raleway",Font.BOLD,20));
        l3.add(textPassword2);

        b1 = new JButton("CHANGE");
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

        setSize(1550,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{

            String pin1 = textPassword1.getText();
            String pin2 = textPassword2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(e.getSource()==b1){
                if(textPassword1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if(textPassword2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }

                Con c1 = new Con();
                String q1 = "update deposit set pin = '"+pin1+"'where pin = '"+password+"'";
                String q2 = "update login set pin = '"+pin1+"'where pin = '"+password+"'";
                String q3 = "update signupthree set Pin_no = '"+pin1+"'where Pin_no = '"+password+"'";


                c1.statement.executeUpdate(q1);
                c1.statement.executeUpdate(q2);
                c1.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new main_Class(password);
            }else if(e.getSource()==b2){
                new main_Class(password);
                setVisible(false);
            }







        }catch(Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Password("");
    }
}
