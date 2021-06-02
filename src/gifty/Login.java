package gifty;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import methods.LoginMethod;

@SuppressWarnings("serial")

public class Login extends JFrame {
	
	public static JTextField username;
	public static JPasswordField password;
	public static String userUsername;
	public static String userEmail;
	public static String userID;
	public static String fullName;
	public static Date userDateOfBirth;
	
	public Login() {
		setResizable(false);
		getContentPane().setBackground(new Color(100, 149, 237));
		setBounds(500, 200, 431, 324);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Title
		JLabel title = new JLabel("Gifty");
		title.setBounds(6, 6, 419, 80);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Snell Roundhand", Font.PLAIN, 40));
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Helvetica", Font.PLAIN, 12));
		usernameLabel.setBounds(119, 104, 193, 16);
		
		username = new JTextField();
		username.setBounds(119, 122, 193, 34);
		
		fullName = new String();
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Helvetica", Font.PLAIN, 12));
		passwordLabel.setBounds(119, 161, 193, 16);
		
		password = new JPasswordField();
		password.setBounds(119, 178, 193, 34);
		
		//'Forgot password' label
		JLabel forgotPass = new JLabel("Forgot password?");
		forgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		forgotPass.setFont(new Font("Helvetica", Font.PLAIN, 10));
		forgotPass.setForeground(new Color(255, 255, 255));
		forgotPass.setBounds(119, 225, 102, 22);
		forgotPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ForgottenPassword fp = new ForgottenPassword();
				fp.setLocationRelativeTo(null);
				fp.setVisible(true);
			}
		});
		
		
		//'Do not have account' label
		JLabel registerHereLabel = new JLabel("Do not have account yet?");
		registerHereLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		registerHereLabel.setForeground(Color.WHITE);
		registerHereLabel.setFont(new Font("Helvetica", Font.PLAIN, 10));
		registerHereLabel.setBounds(119, 245, 193, 22);
		
		//'Register here' link
		JLabel registerHereLink = new JLabel("Register here.");
		registerHereLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerHereLink.setForeground(Color.WHITE);
		registerHereLink.setFont(new Font("Helvetica", Font.BOLD, 10));
		registerHereLink.setBounds(119, 259, 193, 22);
		registerHereLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Registration registration = new Registration();
				registration.setLocationRelativeTo(null);
				registration.setVisible(true);
			}
		});
		
		//Login button
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(233, 221, 79, 29);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LoginMethod.login()) {
					dispose();
					HomePage home = new HomePage();
					home.setLocationRelativeTo(null);
					home.setVisible(true);
				}
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().add(title);
		getContentPane().add(passwordLabel);
		getContentPane().add(usernameLabel);
		getContentPane().add(username);
		getContentPane().add(password);
		getContentPane().add(forgotPass);
		getContentPane().add(registerHereLabel);
		getContentPane().add(registerHereLink);
		getContentPane().add(loginButton);
	}
}
