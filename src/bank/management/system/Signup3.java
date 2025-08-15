package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup3 extends JFrame implements ActionListener {
    JCheckBox s1,s2,s3,s4,s5,s6;
    JTextField Cardnum ;
    JPasswordField Pinnum;
    JButton buttomSubmit , buttonclear;
    JRadioButton buttonAcctype1 , buttonAcctype2,license;
    String formno;
    Signup3(String formno){
        super("APPLICATION FORM");
        this.formno = formno;
        ImageIcon bankimg = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image imgbank = bankimg.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(imgbank);
        JLabel image1 = new JLabel(i1);
        image1.setBounds(50,5,100,100);
        add(image1);

        JLabel l1 = new JLabel("Page 3");
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(400,60,400,30);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        l2.setBounds(360,100,400,30);
        add(l2);

        JLabel labelAccType = new JLabel("Accont Type:");
        labelAccType.setFont(new Font("Raleway",Font.BOLD,18));
        labelAccType.setBounds(180,160,500,30);
        add(labelAccType);


        buttonAcctype1 = new JRadioButton("Savings");
        buttonAcctype1.setFont(new Font("Raleway",Font.BOLD,17));
        buttonAcctype1.setBackground(new Color(215,252,252));
        buttonAcctype1.setBounds(320,160,100,30);
        add(buttonAcctype1);

        buttonAcctype2 = new JRadioButton("Current");
        buttonAcctype2.setFont(new Font("Raleway",Font.BOLD,17));
        buttonAcctype2.setBackground(new Color(215,252,252));
        buttonAcctype2.setBounds(450,160,100,30);
        add(buttonAcctype2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(buttonAcctype1);
        buttonGroup1.add(buttonAcctype2);

        JLabel labelCard = new JLabel("Card No:");
        labelCard.setBounds(180,210,500,30);
        labelCard.setFont(new Font("Raleway",Font.BOLD,18));
        add(labelCard);

        JLabel labelCard1 = new JLabel("(Your 16-digit Card Number)");
        labelCard1.setBounds(180,230,500,30);
        labelCard1.setFont(new Font("Raleway",Font.BOLD,11));
        add(labelCard1);

        Cardnum = new JTextField();
        Cardnum.setBounds(300,210,300,30);
        Cardnum.setFont(new Font("Raleway",Font.BOLD,18));
        add(Cardnum);

        JLabel labelpin = new JLabel("PIN:");
        labelpin.setBounds(180,260,500,30);
        labelpin.setFont(new Font("Raleway",Font.BOLD,18));
        add(labelpin);

        Pinnum = new JPasswordField();
        Pinnum.setBounds(300,260,150,30);
        Pinnum.setFont(new Font("Raleway",Font.BOLD,18));
        add(Pinnum);

        JLabel labelService = new JLabel("Services Required:");
        labelService.setBounds(180,310,500,30);
        labelService.setFont(new Font("Raleway",Font.BOLD,18));
        add(labelService);

        s1 = new JCheckBox("ATM");
        s1.setBackground(new Color(215,252,252));
        s1.setBounds(180,360,200,30);
        s1.setFont(new Font("Raleway",Font.BOLD,18));
        add(s1);

        s2 = new JCheckBox("EMAIL Alerts");
        s2.setBackground(new Color(215,252,252));
        s2.setBounds(400,360,200,30);
        s2.setFont(new Font("Raleway",Font.BOLD,18));
        add(s2);

        s3 = new JCheckBox("Cheque Book");
        s3.setBackground(new Color(215,252,252));
        s3.setBounds(180,410,200,30);
        s3.setFont(new Font("Raleway",Font.BOLD,18));
        add(s3);

        s4 = new JCheckBox("E-Statement");
        s4.setBackground(new Color(215,252,252));
        s4.setBounds(400,410,200,30);
        s4.setFont(new Font("Raleway",Font.BOLD,18));
        add(s4);

        license = new JRadioButton("I hereby declares that the above enterd details are correct to the best of my knowledge.");
        license.setBackground(new Color(215,252,252));
        license.setBounds(200,500,600,30);
        license.setFont(new Font("Raleway",Font.BOLD,12));
        add(license);

        JLabel labelappNo = new JLabel("Form No:");
        labelappNo.setFont(new Font("Raleway",Font.BOLD,14));
        labelappNo.setBounds(520,10,100,30);
        add(labelappNo);  this.formno = formno;

        JLabel displayappNo = new JLabel(formno);
        displayappNo.setFont(new Font("Raleway",Font.BOLD,14));
        displayappNo.setBounds(700,10,100,30);
        add(displayappNo);

        buttomSubmit = new JButton("SUBMIT");
        buttomSubmit.setBounds(280,550,100,30);
        buttomSubmit.setBackground(Color.BLACK);
        buttomSubmit.setForeground(Color.WHITE);
        buttomSubmit.setFont(new Font("Raleway",Font.BOLD,12));
        buttomSubmit.addActionListener(this);
        add(buttomSubmit);


        buttonclear = new JButton("CANCEL");
        buttonclear.setBounds(420,550,100,30);
        buttonclear.setBackground(Color.BLACK);
        buttonclear.setForeground(Color.WHITE);
        buttonclear.setFont(new Font("Raleway",Font.BOLD,12));
        buttonclear.addActionListener(this);
        add(buttonclear);




        setLayout(null);
        setSize(850,800);
        getContentPane().setBackground(new Color(215,252,252));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Acctype = null;
        String li = license.getText();
        if(buttonAcctype1.isSelected()){
            Acctype = "Saving Account";
        }else if(buttonAcctype2.isSelected()){
            Acctype = "Current Account";
        }

        String cardno = Cardnum.getText();

        char[] passwordChars = Pinnum.getPassword(); // returns char array
        String password = new String(passwordChars);       // convert to String if needed

        String service = "";
        if(s1.isSelected()){
            service += "ATM ";
        } else if (s2.isSelected()) {
            service += "EMAIL Alerts ";
        } else if (s3.isSelected()) {
            service += "Cheque Book ";
        }else if(s4.isSelected()){
            service += "E-Statement";
        }

        try{

            if(e.getSource()==buttomSubmit){

                if(Acctype.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else{

                    Con c1 = new Con();
                    String  q1 = "insert into signupthree values('"+formno+"','"+Acctype+"','"+cardno+"','"+password+"','"+service+"')";
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+password+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardno+"\n Pin: "+password);
                    new Deposit(password);
                    setVisible(false);
                }

            }else if(e.getSource()==buttonclear){
                System.exit(0);
            }



        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
