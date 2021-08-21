package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame {

	private int x_pressed, y_pressed;



	public LoginForm() {
		setTitle("Login Form");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(new Color(0f, 0f, 0f, 0f));
		setLayout(null);

		JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/images/login.png")));
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

		JTextField txtUsername = new JTextField();
		txtUsername.setBounds(84, 162, 180, 25);
		txtUsername.setBorder(null);
		bg.add(txtUsername);

		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(84, 209, 180, 25);
		txtPassword.setBorder(null);
		bg.add(txtPassword);

		Font font = new Font("Arial", Font.PLAIN, 11);

		JLabel lbl1 = new JLabel("Don't have account?");
		lbl1.setBounds(80, 320, 120, 30);
		lbl1.setForeground(Color.black);
		lbl1.setFont(font);
		bg.add(lbl1);

		JLabel lblSignup = new JLabel("Sign Up");
		lblSignup.setBounds(183, 320, 65, 30);
		lblSignup.setForeground(Color.orange);
		lblSignup.setFont(font);
		bg.add(lblSignup);
		lblSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				super.mouseClicked(me);
				LoginForm.this.setVisible(false);
				new RegisterForm();
			}
		});

		add(bg);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LoginForm();

	}

}
