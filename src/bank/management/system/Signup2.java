package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Signup2 extends JFrame implements ActionListener {

    JRadioButton button1, button2,button3,button4;
    JComboBox  comboCategory, comboIncome,comboProfession;
    String formno;
    JButton next;
    JTextField textPan , textAadhar;
    Signup2(String formno){
        super("APPLICATION FORM");
        this.formno = formno;
        ImageIcon bankimg = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image imgbank = bankimg.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(imgbank);
        JLabel image1 = new JLabel(i1);
        image1.setBounds(50,5,100,100);
        add(image1);



        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(400,60,400,30);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        l2.setBounds(360,100,400,30);
        add(l2);


        JLabel labelCategory = new JLabel("Category:");
        labelCategory.setFont(new Font("Raleway",Font.BOLD,18));
        labelCategory.setBounds(180,210,500,30);
        add(labelCategory);

        String Category[] = {"General","OC","OBC","SC","ST","Other"};
        comboCategory = new JComboBox(Category);
        comboCategory.setFont(new Font("Raleway",Font.BOLD,17));
        comboCategory.setBackground(new Color(252,208,76));
        comboCategory.setBounds(320,210,320,30);
        add(comboCategory);


        JLabel labelProfession = new JLabel("Profession:");
        labelProfession.setFont(new Font("Raleway",Font.BOLD,18));
        labelProfession.setBounds(180,260,500,30);
        add(labelProfession);

        String Profession[] = {"Student","Salaried","Self-Employed","Business","Retired","Homemaker","Other"};
        comboProfession = new JComboBox(Profession);
        comboProfession.setFont(new Font("Raleway",Font.BOLD,17));
        comboProfession.setBackground(new Color(252,208,76));
        comboProfession.setBounds(320,260,320,30);
        add(comboProfession);

        JLabel labelIncome = new JLabel("Income:");
        labelIncome.setFont(new Font("Raleway",Font.BOLD,18));
        labelIncome.setBounds(180,310,500,30);
        add(labelIncome);

        String Income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","<10,00,000"};
        comboIncome = new JComboBox(Income);
        comboIncome.setFont(new Font("Raleway",Font.BOLD,17));
        comboIncome.setBackground(new Color(252,208,76));
        comboIncome.setBounds(320,310,320,30);
        add(comboIncome);

        JLabel labelPan = new JLabel("PAN No:");
        labelPan.setFont(new Font("Raleway",Font.BOLD,18));
        labelPan.setBounds(180,360,500,30);
        add(labelPan);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway",Font.BOLD,14));
        textPan.setBounds(320,360,300,30);
        add(textPan);

        JLabel labelAadhar = new JLabel("Aadhar No:");
        labelAadhar.setFont(new Font("Raleway",Font.BOLD,18));
        labelAadhar.setBounds(180,410,500,30);
        add(labelAadhar);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway",Font.BOLD,14));
        textAadhar.setBounds(320,410,300,30);
        add(textAadhar);

        JLabel labelCitizer = new JLabel("Senior Citizen:");
        labelCitizer.setFont(new Font("Raleway",Font.BOLD,18));
        labelCitizer.setBounds(180,460,500,30);
        add(labelCitizer);


        button1 = new JRadioButton("Yes");
        button1.setBackground(new Color(252,208,76));
        button1.setFont(new Font("Raleway",Font.BOLD,18));
        button1.setBounds(360,460,80,30);
        add(button1);

        button2 = new JRadioButton("No");
        button2.setBackground(new Color(252,208,76));
        button2.setFont(new Font("Raleway",Font.BOLD,18));
        button2.setBounds(460,460,80,30);
        add(button2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(button1);
        buttonGroup1.add(button2);

        JLabel labelAcc = new JLabel("Existing Account:");
        labelAcc.setFont(new Font("Raleway",Font.BOLD,18));
        labelAcc.setBounds(180,510,500,30);
        add(labelAcc);

        button3 = new JRadioButton("Yes");
        button3.setBackground(new Color(252,208,76));
        button3.setFont(new Font("Raleway",Font.BOLD,18));
        button3.setBounds(360,510,80,30);
        add(button3);

        button4 = new JRadioButton("No");
        button4.setBackground(new Color(252,208,76));
        button4.setFont(new Font("Raleway",Font.BOLD,18));
        button4.setBounds(460,510,80,30);
        add(button4);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(button3);
        buttonGroup2.add(button4);

        JLabel labelappNo = new JLabel("Form No:");
        labelappNo.setFont(new Font("Raleway",Font.BOLD,14));
        labelappNo.setBounds(520,10,100,30);
        add(labelappNo);

        JLabel displayappNo = new JLabel(formno);
        displayappNo.setFont(new Font("Raleway",Font.BOLD,14));
        displayappNo.setBounds(700,10,100,30);
        add(displayappNo);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570,620,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(252,190,76));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           String catagory = (String) comboCategory.getSelectedItem();
           String Profession = (String) comboProfession.getSelectedItem();
           String Income = (String) comboIncome.getSelectedItem();
           String PAN_No = textPan.getText();
           String Aadhar = textAadhar.getText();
           String Senior = null;
           if(button1.isSelected()){
               Senior = "Yes";
           }else if(button2.isSelected()){
               Senior = "No";
           }
           String Exist_acc = null;
        if(button3.isSelected()){
            Exist_acc = "Yes";
        }else if(button4.isSelected()){
            Exist_acc = "No";
        }

        try{
            if(textPan.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            else{
                Con c1 = new Con();
                String q = "insert into Signuptwo values('"+formno+"','"+catagory+"','"+Profession+"','"+Income+"','"+PAN_No+"','"+Aadhar+"','"+Senior+"','"+Exist_acc+"')";

                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
