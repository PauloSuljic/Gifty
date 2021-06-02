package methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import gifty.DBConnection;

import gifty.Login;

public class LoginMethod {
	 public static Boolean login(){	 
		try {
			Connection con = DBConnection.getDBConnection();
			//Query
			Statement stmt=con.createStatement();
		
			String sql = "Select * from users where (username='"+Login.username.getText()+"' or email='"+Login.userEmail+"') "
					+ "and password='"+RegistrationMethods.generateHash(Login.password.getText())+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()){
				
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				
				
				//Fullname to get initials
				Login.fullName = firstName + " " + lastName;
				Login.userUsername = Login.username.getText();
				
				Login.userEmail = rs.getString("email");
				Login.userID = rs.getString("idUser");
				Login.userDateOfBirth = rs.getDate("dateOfBirth");
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Wrong username or password");
				Login.username.setText("");
				Login.password.setText("");
				return false;
			}
			
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
			return false;
		}
		return true;
	}
	
}
