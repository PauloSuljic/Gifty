package gifty;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MyProfilePanel extends JPanel {
	
	public MyProfilePanel() {

		//Main Section
		setLayout(null);
		setBounds(137, 148, 733, 349);
		setBackground(new Color(100, 149, 237));
		
		JPanel panel = new JPanel();
		panel.setBounds(185, 12, 363, 325);
		panel.setBackground(new Color(65, 105, 225));
		
		JLabel fullName = new JLabel("");
		fullName.setBounds(6, 20, 351, 38);
		fullName.setHorizontalAlignment(SwingConstants.CENTER);
		fullName.setFont(new Font("Helvetica", Font.PLAIN, 20));
		fullName.setForeground(new Color(255, 255, 255));
		fullName.setText(Login.fullName);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(23, 96, 122, 28);
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(23, 153, 122, 28);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		JLabel yourIdLabel = new JLabel("Gifty ID: ");
		yourIdLabel.setBounds(23, 210, 122, 28);
		yourIdLabel.setForeground(Color.WHITE);
		yourIdLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		JLabel username = new JLabel("");
		username.setBounds(157, 96, 200, 28);
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Helvetica", Font.PLAIN, 15));
		username.setText(Login.userUsername);
		
		JLabel email = new JLabel("");
		email.setBounds(157, 153, 200, 28);
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Helvetica", Font.PLAIN, 15));
		email.setText(Login.userEmail);
		
		JLabel yourId = new JLabel("");
		yourId.setBounds(157, 210, 200, 28);
		yourId.setForeground(Color.WHITE);
		yourId.setFont(new Font("Helvetica", Font.PLAIN, 15));
		yourId.setText(Login.userID);
		
		JLabel birthdayLabel = new JLabel("Birthday:");
		birthdayLabel.setBounds(23, 267, 122, 28);
		birthdayLabel.setForeground(Color.WHITE);
		birthdayLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		JLabel birthday = new JLabel("");
		birthday.setBounds(157, 267, 200, 28);
		birthday.setForeground(Color.WHITE);
		birthday.setFont(new Font("Helvetica", Font.PLAIN, 15));
		birthday.setText(Login.userDateOfBirth.toString());
		
		setLayout(null);
		add(panel);
		panel.setLayout(null);
		panel.add(fullName);
		panel.add(usernameLabel);
		panel.add(username);
		panel.add(emailLabel);
		panel.add(email);
		panel.add(yourIdLabel);
		panel.add(yourId);
		panel.add(birthdayLabel);
		panel.add(birthday);

	}

}
