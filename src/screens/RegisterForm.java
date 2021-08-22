package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterForm extends JFrame {

    private int x_pressed, y_pressed;
    static String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    static String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    static String years[] = {"2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010",
            "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998"};

    public RegisterForm() {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(0f, 0f, 0f, 0f));
        setLayout(null);

        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/images/bg.png")));
        bg.setBounds(0, 0, 600, 400);
        bg.setLayout(null);

        bg.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x_pressed = e.getX();
                y_pressed = e.getY();
            }
        });

        bg.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(e.getXOnScreen() - x_pressed, e.getYOnScreen() - y_pressed);
            }
        });

        JLabel lblClose = new JLabel(new ImageIcon(getClass().getResource("/images/ic_close.png")));
        lblClose.setBounds(560, 10, 30, 30);
        lblClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                System.exit(0);
            }
        });
        bg.add(lblClose);

        JTextField txtName = new JTextField();
        txtName.setBounds(85, 60, 180, 25);
        txtName.setBorder(null);
        bg.add(txtName);

        JTextField txtMobile = new JTextField();
        txtMobile.setBounds(85, 98, 180, 25);
        txtMobile.setBorder(null);
        bg.add(txtMobile);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(85, 134, 180, 25);
        txtEmail.setBorder(null);
        bg.add(txtEmail);

        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(85, 171, 180, 25);
        txtAddress.setBorder(null);
        bg.add(txtAddress);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(85, 209, 180, 25);
        txtPassword.setBorder(null);
        bg.add(txtPassword);

        JRadioButton rdoMale = new JRadioButton("Male");
        JRadioButton rdoFemale = new JRadioButton("Female");
        rdoMale.setBounds(85, 248, 80, 20);
        rdoFemale.setBounds(170, 248, 80, 20);
        rdoMale.setBackground(Color.white);
        rdoFemale.setBackground(Color.white);
        rdoMale.setSelected(true);
        bg.add(rdoMale);
        bg.add(rdoFemale);
        ButtonGroup gen = new ButtonGroup();
        gen.add(rdoMale);
        gen.add(rdoFemale);

        JComboBox<String> cmbDay = new JComboBox<String>(days);
        JComboBox<String> cmbMonth = new JComboBox<String>(months);
        JComboBox<String> cmbYear = new JComboBox<String>(years);
        cmbDay.setBounds(80, 283, 50, 20);
        cmbMonth.setBounds(150, 283, 50, 20);
        cmbYear.setBounds(220, 283, 60, 20);
        bg.add(cmbDay);
        bg.add(cmbMonth);
        bg.add(cmbYear);

        JCheckBox chkTerms = new JCheckBox("I accept Terms & Conditions");
        chkTerms.setBounds(20, 320, 250, 20);
        chkTerms.setBackground(Color.white);
        bg.add(chkTerms);

        JLabel lblRegister = new JLabel();
        lblRegister.setBounds(200, 350, 130, 40);
        lblRegister.setBackground(Color.black);
        lblRegister.addMouseListener(new MouseAdapter() {
            // Empty field condition added.
            @Override
            public void mouseClicked(MouseEvent e) {
                String string_mobile = txtMobile.getText();
                if (!txtName.getText().equals("")) {
                    if (txtMobile.getText().trim().length() == 10 && !txtMobile.getText().equals("")) {
                        try{
                            long int_string_mobile = Long.parseLong(string_mobile);
                        }catch (NumberFormatException er){
                            JOptionPane.showMessageDialog(bg,"Please enter digit");
                            return;
                        }
                        if (!txtEmail.getText().equals("")) {
                            if (!txtAddress.getText().equals("")) {
                                if (!txtPassword.getText().equals("")) {
                                    if (chkTerms.isSelected()) {
                                        JOptionPane.showMessageDialog(lblRegister, "Welcome to Awesome Design");
                                        bg.setVisible(false);
                                        new Driver_dashboard();

                                    } else {
                                        JOptionPane.showMessageDialog(lblRegister, "Terms and condition not selected!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(lblRegister, "Password Cannot be empty!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(lblRegister, "Address cannot be empty!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(lblRegister, "Email cannot be empty!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(lblRegister, "Mobile number is empty or is lesser/greater than 10 digit!");
                    }
                } else {
                    JOptionPane.showMessageDialog(lblRegister, "Name cannot be empty!");
                }
            }
        });
        bg.add(lblRegister);

        Font font = new Font("Arial", Font.BOLD, 11);

        JLabel lblSignIn = new JLabel("Sign In");
        lblSignIn.setBounds(145, 350, 50, 30);
        lblSignIn.setForeground(Color.orange);
        lblSignIn.setFont(font);
        bg.add(lblSignIn);
        lblSignIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                RegisterForm.this.setVisible(false);
                new LoginForm();
            }
        });

        add(bg);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterForm();
    }
}