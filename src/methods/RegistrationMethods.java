package methods;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import gifty.DBConnection;
import gifty.Registration;

public class RegistrationMethods {
	
	public static String generateHash(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1,messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	static public Boolean signIn() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Data input
			Registration.firstNameInput = Registration.firstName.getText();
			Registration.lastNameInput = Registration.lastName.getText();
			Registration.emailInput = Registration.email.getText();
			Registration.usernameInput = Registration.username.getText();
			Registration.passwordInput = Registration.password.getText();
			Registration.rePasswordInput = Registration.rePassword.getText();
			
			//Check if first name empty and initials to uppercase
			if (Registration.firstNameInput.length()>0) {
				Registration.firstNameInput = Registration.firstName.getText().substring(0, 1).toUpperCase() + 
						Registration.firstName.getText().substring(1);
			}else {
				Registration.firstNameInput="";
			}
			
			//Check if last name empty and initials to uppercase
			if (Registration.lastNameInput.length()>0) {
				Registration.lastNameInput = Registration.lastName.getText().substring(0, 1).toUpperCase() + 
						Registration.lastName.getText().substring(1);
			}else {
				Registration.lastNameInput="";
			}
			
			Registration.sdf = new SimpleDateFormat("yyyy/MM/dd");
			Registration.chosenDate = Registration.dateChooser.getDate();
			
			//Email validator
			String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
	        Pattern pattern = Pattern.compile(regex);   
            Matcher matcher = pattern.matcher(Registration.emailInput);
            
            //Username exists 
            Statement stmt=con.createStatement();
			String sql = "SELECT username FROM users where username= '"+Registration.usernameInput+"' ";		
			ResultSet rs = stmt.executeQuery(sql);
			
			//Email exists
			Statement stmt2=con.createStatement();
			String sql2 = "SELECT email FROM users where email= '"+Registration.emailInput+"' ";
			ResultSet rs2 = stmt2.executeQuery(sql2);
			
			//'All data has value' validation
			if ((Registration.firstNameInput.equals("")) || (Registration.lastNameInput.equals("")) || (Registration.emailInput.equals("")) || (Registration.usernameInput.equals("")) || 
					(Registration.passwordInput.equals("")) || (Registration.chosenDate==null))
			
			{
				JOptionPane.showMessageDialog(null, "You must insert all the data");
				return false;
			
			//Email validation
			
			}else if(!matcher.matches()){
				JOptionPane.showMessageDialog(null, "Enter valid email address");
				return false;
			}
			
			//'Matched password' validation
				
			else if(!Registration.passwordInput.equals(Registration.rePasswordInput)) {	
				JOptionPane.showMessageDialog(null, "Passwords do not match!");
				return false;
			}
			
			//'Username already exists' validation
			else if (rs.next()){
				JOptionPane.showMessageDialog(null, "That username already exists");
				Registration.usernameInput = "";
				rs.close();
				stmt.close();
				return false;
			}
			
			//Email already exists validation
			else if (rs2.next()){
				JOptionPane.showMessageDialog(null, "That email already exists");
				Registration.emailInput = "";
				rs2.close();
				stmt2.close();
				return false;
			}
			
			//Insert user into database
			else {
				insertUserData();
			}
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
			return false;
		}
		return true;
	}
	
	public static Boolean insertUserData(){	 
		try {
			Connection con = DBConnection.getDBConnection();
			
			Statement stmt=con.createStatement();
			
			String sql = "Insert into users (firstName, lastName, email, username, password, dateOfBirth) values "
					+ "('"+ Registration.firstNameInput +"', '"+ Registration.lastNameInput +"', "
					+ "'"+ Registration.emailInput +"', '"+ Registration.usernameInput +"',"
					+ " '"+ RegistrationMethods.generateHash(Registration.passwordInput) +"', "
					+ "'"+ Registration.sdf.format(Registration.chosenDate) +"')";
			
			stmt.execute(sql);
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "You have successfully made an account.");
			
			con.close();
		}catch (Exception e){
			return false;
		}
		return true;
	}
}
