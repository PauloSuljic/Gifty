package methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import gifty.DBConnection;
import gifty.ForgottenPassword;

public class MailMethods {
	static Session newSession = null;
	static MimeMessage mimeMessage = null;
	
	static String newRandomPassword;
	public static String verificationCode; 
	
	public static Boolean checkIfMailExists() {
		try {
		// Open connection
		Connection con = DBConnection.getDBConnection();
		
		Statement stmt=con.createStatement();
		
		String sql = "SELECT email FROM users where email= '"+ForgottenPassword.enterEmailText.getText()+"' ";
				
		ResultSet rs = stmt.executeQuery(sql);

		if (!rs.next()){
			return false;
		}
		
		rs.close();
		stmt.close();
		con.close();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
			
		}
		return true;
	}
	
	public static String randomString() {
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String randomString = "";
		
		int lenght = 8;
		
		Random rand = new Random();
		
		char[] text = new char [lenght];
		
		for (int i = 0; i < lenght; i++) {
			text[i] = characters.charAt(rand.nextInt(characters.length()));
		}
		
		for (int i = 0; i < text.length; i++) {
			randomString += text[i];
		}
		
		return randomString;
			
	}
	
	public static void setupServerProperties(){
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		newSession = Session.getDefaultInstance(properties,null);
	}
	
	public static MimeMessage draftEmail() throws AddressException, MessagingException{
		String emailReceipients = ForgottenPassword.enterEmailText.getText();
		String emailSubject = "Test email";
		newRandomPassword = randomString();
		verificationCode = randomString();
		
		String emailBody = "Your New Password is: " + newRandomPassword + System.lineSeparator()
				+ "Verification Code: " + verificationCode;
		
		System.out.println(emailBody);
		
		mimeMessage = new MimeMessage(newSession);
		
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients));
		mimeMessage.setSubject(emailSubject);
		
		MimeBodyPart bodyPart = new MimeBodyPart();

		bodyPart.setContent(emailBody, "html/text");
		
		MimeMultipart mimeMultipart = new MimeMultipart();
		mimeMultipart.addBodyPart(bodyPart);
		
		mimeMessage.setContent(mimeMultipart);
		
		return mimeMessage;
		
	}
	
	public static void changePassword() {
		try {
		// Open connection
		Connection con = DBConnection.getDBConnection();
		
		Statement stmt=con.createStatement();
		
		String sql = "update users set password = '"+RegistrationMethods.generateHash(newRandomPassword)+"' "
				+ "where email = '"+ForgottenPassword.enterEmailText.getText() +"' ";
				
		stmt.execute(sql);
		
		stmt.close();
		con.close();
		
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
			
		}
		
	}
	
	public static void sendEmail() throws MessagingException {
		String fromUser = "gifty-support@gmail.com";
		String fromUserPassword = "programskoinzinjerstvo";
		String emailHost = "smtp.gmail.com";
		
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		
	}
}
