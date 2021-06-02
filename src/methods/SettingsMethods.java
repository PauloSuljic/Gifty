package methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import gifty.DBConnection;
import gifty.Login;
import gifty.Settings;

public class SettingsMethods {
	public static void deleteAccount() {

		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
		
			String sql = "Delete from users where idUser = '"+Login.userID+"'";
			
			stmt.execute(sql);
			
			stmt.close();
			con.close();
			
			System.exit(0);
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static void getFriendshipIds() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "select idFriendship from giftyDB.friendships inner join giftyDB.users "
					+ "on idUser = requestReceiver or idUser = requestSender "
					+ "where idUser = '"+Login.userID+"' ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			Settings.friendships = new ArrayList<Integer>();
			
			while (rs.next()){	
				Settings.friendships.add(rs.getInt("idFriendship"));
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
		
	}
	
	public static void getWishlistItemIds() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "select idWishlistItem from giftyDB.wishlist inner join giftyDB.users " + 
					"on wishlist.idUser = users.idUser " + 
					"where users.idUser = '"+Login.userID+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			Settings.wishlistItems = new ArrayList<Integer>();
			
			while (rs.next()){	
				Settings.wishlistItems.add(rs.getInt("idWishlistItem"));
				//System.out.println(rs.getInt("idWishlistItem"));
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
		
	}
	
	public static void deleteWishlist() {	
		for (Integer wishlistId : Settings.wishlistItems) {
			try {
				// Open connection
				Connection con = DBConnection.getDBConnection();
				
				//Query
				Statement stmt=con.createStatement();
			
				String sql = "Delete from wishlist where idWishlistItem = '"+wishlistId+"'";

				stmt.execute(sql);
				
				stmt.close();
				con.close();
				
			}catch (Exception e2){
				JOptionPane.showMessageDialog(null, e2);
			}
		}
		
	}
	
	public static void deleteFriendships() {	
		for (Integer friendshipId : Settings.friendships) {
			try {
				// Open connection
				Connection con = DBConnection.getDBConnection();
				
				//Query
				Statement stmt=con.createStatement();
			
				String sql = "Delete from friendships where idFriendship = '"+friendshipId+"'";

				stmt.execute(sql);
				
				stmt.close();
				con.close();
				
			}catch (Exception e2){
				JOptionPane.showMessageDialog(null, e2);
			}
		}
	}
		
	public static void changePassword() {

		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
		
			String sql = "Update users set password = '"+RegistrationMethods.generateHash(Settings.newPasswordText.getText())+"' "
					+ "where idUser = '"+Login.userID+"'";
			
			stmt.execute(sql);
			
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "You have changed your password");
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
}
