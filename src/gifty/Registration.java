package gifty;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import methods.RegistrationMethods;

@SuppressWarnings("serial")
public class Registration extends JFrame {
	public static JTextField firstName;
	public static JTextField lastName;
	public static JTextField email;
	public static JTextField username;
	public static JPasswordField password;
	public static JPasswordField rePassword;
	public static JDateChooser dateChooser;
	
	public static String firstNameInput;
	public static String lastNameInput;
	public static String emailInput;
	public static String usernameInput;
	public static String passwordInput;
	public static String rePasswordInput;
	public static Date chosenDate;
	
	public static SimpleDateFormat sdf;
	
	public Registration() {
		setResizable(false);
		getContentPane().setBackground(new Color(100, 149, 237));
		getContentPane().setLayout(null);
		setBounds(100, 100, 600, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Title
		JLabel title = new JLabel("Gifty");
		title.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Snell Roundhand", Font.PLAIN, 40));
		title.setEnabled(true);
		title.setForeground(new Color(255, 255, 255));
		title.setBounds(6, 6, 588, 80);
		
		//Panels
		JPanel registrationPanel = new JPanel();
		registrationPanel.setBackground(new Color(100, 149, 237));
		registrationPanel.setBounds(6, 90, 594, 338);
		registrationPanel.setLayout(null);
		
		JPanel registrationTextPanel = new JPanel();
		registrationTextPanel.setBackground(new Color(100, 149, 237));
		registrationTextPanel.setBounds(6, 6, 288, 320);
		registrationTextPanel.setLayout(null);
		
		//Labels
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setForeground(new Color(255, 255, 255));
		firstNameLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		firstNameLabel.setBounds(6, 13, 100, 30);
		
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setForeground(Color.WHITE);
		lastNameLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lastNameLabel.setBounds(6, 56, 100, 30);
		
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		emailLabel.setBounds(6, 99, 100, 30);
		
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		usernameLabel.setBounds(6, 142, 100, 30);
		
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		passwordLabel.setBounds(6, 185, 100, 30);
			
		JLabel repeatPasswordLabel = new JLabel("Re-password");
		repeatPasswordLabel.setForeground(Color.WHITE);
		repeatPasswordLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		repeatPasswordLabel.setBounds(6, 228, 100, 30);
		
		//Inputs
		firstName = new JTextField();
		firstName.setBounds(112, 14, 170, 26);
		
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(112, 57, 170, 26);
		
		lastName.setColumns(10);
		
		email = new JTextField();
		email.setBounds(112, 100, 170, 26);
		
		email.setColumns(10);
		
		username = new JTextField();
		username.setBounds(112, 143, 170, 26);
		
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(112, 186, 170, 26);
		
		rePassword = new JPasswordField();
		rePassword.setBounds(112, 229, 170, 26);
		
		//Gift image
		JPanel registrationImagePanel = new JPanel();
		registrationImagePanel.setBackground(new Color(100, 149, 237));
		registrationImagePanel.setBounds(294, 6, 300, 332);
		registrationImagePanel.setLayout(null);
		
		JLabel registrationIcon = new JLabel("");
		Image imgGift = new ImageIcon(this.getClass().getResource("/giftbox3.png")).getImage();
		registrationIcon.setIcon(new ImageIcon(imgGift));
		registrationIcon.setHorizontalAlignment(SwingConstants.CENTER);
		registrationIcon.setBounds(70, 100, 276, 308);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(6, 270, 100, 30);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(122, 274, 157, 26);
		
		//'Back to Login' link
		JLabel goBackLabel = new JLabel("GO BACK TO LOGIN PAGE");
		goBackLabel.setBounds(56, 70, 186, 30);
		goBackLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goBackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goBackLabel.setForeground(Color.WHITE);
		goBackLabel.setFont(new Font("Helvetica", Font.PLAIN, 12));
		goBackLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		
		//Registration button
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(99, 16, 100, 30);
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrationMethods.signIn();
			}
		});
		
		JLabel orLabel = new JLabel("or");
		orLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		orLabel.setForeground(Color.WHITE);
		orLabel.setBounds(121, 52, 61, 16);
		
		getContentPane().add(title);
		getContentPane().add(registrationPanel);
		
		registrationPanel.add(registrationTextPanel);
		registrationPanel.add(registrationImagePanel);
		
		//Add labels
		registrationTextPanel.add(firstNameLabel);
		registrationTextPanel.add(lastNameLabel);
		registrationTextPanel.add(emailLabel);
		registrationTextPanel.add(usernameLabel);
		registrationTextPanel.add(passwordLabel);
		registrationTextPanel.add(repeatPasswordLabel);
		registrationTextPanel.add(lblDateOfBirth);
		
		registrationImagePanel.add(goBackLabel);
		registrationImagePanel.add(orLabel);
		registrationImagePanel.add(btnSignIn);
		registrationImagePanel.add(registrationIcon);
		
		//Add input fields
		registrationTextPanel.add(firstName);
		registrationTextPanel.add(lastName);
		registrationTextPanel.add(email);
		registrationTextPanel.add(username);
		registrationTextPanel.add(password);
		registrationTextPanel.add(rePassword);
		registrationTextPanel.add(dateChooser);
		
	}
}
