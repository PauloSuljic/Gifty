package gifty;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import methods.MailMethods;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VerificationCode extends JFrame {
	private JTextField verificationCodeText;

	public VerificationCode() {
		setResizable(false);
		getContentPane().setBackground(new Color(100, 149, 237));
		setBounds(500, 200, 431, 324);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Gifty");
		title.setBounds(6, 6, 419, 80);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Snell Roundhand", Font.PLAIN, 40));
		
		getContentPane().setLayout(null);
		getContentPane().add(title);
		
		verificationCodeText = new JTextField();
		verificationCodeText.setBounds(120, 153, 193, 26);
		getContentPane().add(verificationCodeText);
		verificationCodeText.setColumns(10);
		
		JLabel enterCodeLabel = new JLabel("Enter verification code");
		enterCodeLabel.setFont(new Font("Helvetica", Font.PLAIN, 14));
		enterCodeLabel.setForeground(new Color(255, 255, 255));
		enterCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterCodeLabel.setBounds(6, 125, 419, 16);
		getContentPane().add(enterCodeLabel);
		
		JButton confirmCodeButton = new JButton("Confirm");
		confirmCodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verificationCodeText.getText().equals(MailMethods.verificationCode)) {
					MailMethods.changePassword();
					JOptionPane.showMessageDialog(null, "Password successfully changed");
					dispose();
					Login lp = new Login();
					lp.setVisible(true);
					lp.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "Wrong verification code");
					verificationCodeText.setText("");
				}
			}
		});
		confirmCodeButton.setBounds(159, 191, 117, 29);
		getContentPane().add(confirmCodeButton);

	}

}
