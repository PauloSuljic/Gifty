package gifty;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import methods.MailMethods;

import javax.swing.JTextField;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ForgottenPassword extends JFrame {
	public static JTextField enterEmailText;
	
	void sendEmailButton() {
		
		//Email validation
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(enterEmailText.getText()); 
        
        if(!matcher.matches()) {
        	JOptionPane.showMessageDialog(null, "Enter valid email address");
        }else {
        	if (MailMethods.checkIfMailExists()) {
        		MailMethods.setupServerProperties();
				try {
					MailMethods.draftEmail();
					//Mail.sendEmail();
					dispose();
					VerificationCode vc = new VerificationCode();
					vc.setVisible(true);
					vc.setLocationRelativeTo(null);
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}else {
        		JOptionPane.showMessageDialog(null, "That email does not exist in our database");
        	}	
        }
	}
	
	public ForgottenPassword() {
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
		
		enterEmailText = new JTextField();
		enterEmailText.setBounds(118, 154, 195, 26);
		getContentPane().add(enterEmailText);
		enterEmailText.setColumns(10);
		
		JLabel enterEmailLabel = new JLabel("Enter your email address");
		enterEmailLabel.setForeground(new Color(255, 255, 255));
		enterEmailLabel.setFont(new Font("Helvetica", Font.PLAIN, 14));
		enterEmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterEmailLabel.setBounds(6, 126, 419, 16);
		getContentPane().add(enterEmailLabel);
		
		JButton sendNewPassButton = new JButton("Send");
		sendNewPassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendEmailButton();
			}
		});
		sendNewPassButton.setBounds(159, 192, 117, 29);
		getContentPane().add(sendNewPassButton);
		
		JLabel goBackLabel = new JLabel("Go back to login page");
		goBackLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login lp = new Login();
				lp.setLocationRelativeTo(null);
				lp.setVisible(true);
			}
		});
		
		goBackLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goBackLabel.setFont(new Font("Helvetica", Font.PLAIN, 11));
		goBackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goBackLabel.setForeground(new Color(255, 255, 255));
		goBackLabel.setBounds(6, 233, 419, 16);
		getContentPane().add(goBackLabel);
	}

}
