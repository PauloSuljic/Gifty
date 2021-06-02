package methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gifty.AddNewFriendPanel;
import gifty.DBConnection;
import gifty.FriendRequestsPanel;
import gifty.FriendsListPanel;
import gifty.FriendsPanel;
import gifty.FriendsProfilePanel;
import gifty.HomePage;
import gifty.HomePanel;
import gifty.Login;
import gifty.Sidebar;

public class FriendMethods {
	
	//Add Friend Methods
	
	public static void loadFriendListAF() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "SELECT username from giftyDB.friendships inner join giftyDB.users\n" + 
					"on giftyDB.users.idUser = giftyDB.friendships.requestReceiver or\n" + 
					"giftyDB.users.idUser = giftyDB.friendships.requestSender\n" + 
					"where (requestReceiver = '"+Login.userID+"' or requestSender = '"+Login.userID+"')"
							+ "and statusReceiver = 1 and statusSender = 1 "
							+ "and not username = '"+Login.userUsername+"' ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			AddNewFriendPanel.friendsListDLM = new DefaultListModel<String>();
			
			while (rs.next()){
					
				AddNewFriendPanel.friendsListDLM.addElement(rs.getString("username"));
				
			}
			rs.close();
			stmt.close();
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static void loadSentRequestList() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "SELECT username from giftyDB.friendships inner join giftyDB.users\n" + 
					"on giftyDB.users.idUser = giftyDB.friendships.requestReceiver or\n" + 
					"giftyDB.users.idUser = giftyDB.friendships.requestSender\n" + 
					"where (requestReceiver = '"+Login.userID+"' or requestSender = '"+Login.userID+"')"
							+ "and statusReceiver = 0 and statusSender = 1 "
							+ "and not username = '"+Login.userUsername+"' ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			AddNewFriendPanel.sentRequestListDLM = new DefaultListModel<String>();
			
			while (rs.next()){
					
				AddNewFriendPanel.sentRequestListDLM.addElement(rs.getString("username"));
				
			}
			
			AddNewFriendPanel.sentRequestList.setModel(AddNewFriendPanel.sentRequestListDLM);
			rs.close();
			stmt.close();
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}

	public static void searchFriend() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
		
			String sql = "Select * from users where idUser='"+AddNewFriendPanel.enterId.getText()+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			
			loadSentRequestList();
			
			if (rs.next()){
				AddNewFriendPanel.usernameOutput = rs.getString("username");
				
				//Check if searched for yourself
				if (AddNewFriendPanel.usernameOutput.equals(Login.userUsername)) {
					AddNewFriendPanel.panel.setVisible(false);
					JOptionPane.showMessageDialog(null, "You entered your Gitfy ID");
				
				//Check if already friends
				}else if(AddNewFriendPanel.friendsListDLM.contains(AddNewFriendPanel.usernameOutput)){
					AddNewFriendPanel.panel.setVisible(false);
					JOptionPane.showMessageDialog(null, "You and '"+AddNewFriendPanel.usernameOutput+"' are already friends");
				//Check if request exists
				}else if(AddNewFriendPanel.sentRequestListDLM.contains(AddNewFriendPanel.usernameOutput)){
					AddNewFriendPanel.panel.setVisible(false);
					JOptionPane.showMessageDialog(null, "Request between you and '"+AddNewFriendPanel.usernameOutput+"' already exists");
				}else {
					AddNewFriendPanel.panel.setVisible(true);
					AddNewFriendPanel.username.setText(AddNewFriendPanel.usernameOutput);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "User not found");
			}
			
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}

	public static void sendRequest() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
		
			String sql = "Insert into friendships (requestSender, requestReceiver, statusSender, statusReceiver) "
					+ "values ('"+ Login.userID +"', "
					+ "'"+ Integer.parseInt(AddNewFriendPanel.enterId.getText()) +"', 1, 0)";
			
			stmt.execute(sql);
			stmt.close();
			
			AddNewFriendPanel.panel.setVisible(false);
			AddNewFriendPanel.enterId.setText("");
			JOptionPane.showMessageDialog(null, "Friend request sent to " + AddNewFriendPanel.usernameOutput);
			
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
	
		}
	}

	//Friends List Methods
	
	public static void loadFriendList() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "SELECT username from giftyDB.friendships inner join giftyDB.users\n" + 
					"on giftyDB.users.idUser = giftyDB.friendships.requestReceiver or\n" + 
					"giftyDB.users.idUser = giftyDB.friendships.requestSender\n" + 
					"where (requestReceiver = '"+Login.userID+"' or requestSender = '"+Login.userID+"')"
							+ "and statusReceiver = 1 and statusSender = 1 "
							+ "and not username = '"+Login.userUsername+"' ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			FriendsListPanel.nameListDLM = new DefaultListModel<String>();
			
			while (rs.next()){
					
				FriendsListPanel.nameListDLM.addElement(rs.getString("username"));
				
			}
			
			FriendsListPanel.nameList.setModel(FriendsListPanel.nameListDLM);
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static void getDataFromSelectedFriend() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "select * from giftyDB.users where username = '"+FriendsListPanel.selectedUser+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()){
					
				FriendsListPanel.selectedFriendUserId = rs.getString("idUser");
				FriendsListPanel.selectedFriendUsername = rs.getString("username");
				FriendsListPanel.selectedFriendEmail = rs.getString("email");
				FriendsListPanel.selectedFriendFullname = rs.getString("firstName") + " " + rs.getString("lastName");
				FriendsListPanel.selectedFriendBirthday = rs.getDate("dateOfBirth");
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
		
	}
	
	//Friend Requests Methods
	
	public static void setNotification(Integer listSize, JLabel notification) {
		if (listSize > 0) {
			notification.setText(listSize.toString());
		}else {
			notification.setVisible(false);
		}
	}
	
	public static void loadRequestList() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "SELECT username from giftyDB.friendships inner join giftyDB.users\n" + 
					"on giftyDB.users.idUser = giftyDB.friendships.requestReceiver or \n" + 
					"giftyDB.users.idUser = giftyDB.friendships.requestSender\n" + 
					"where (requestReceiver = '"+Login.userID+"') \n" + 
					"and statusReceiver = 0 and statusSender = 1 \n" + 
					"and not username = '"+Login.userUsername+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			FriendRequestsPanel.requestListDLM = new DefaultListModel<String>();
			
			while (rs.next()){
					
				FriendRequestsPanel.requestListDLM.addElement(rs.getString("username"));
				
			}
			
			FriendRequestsPanel.requestList.setModel(FriendRequestsPanel.requestListDLM);
			
			if (FriendRequestsPanel.requestListDLM.size() >= 0) {
				FriendRequestsPanel.listSize = FriendRequestsPanel.requestListDLM.size();
				try{
					setNotification(FriendRequestsPanel.listSize, HomePanel.notification);
					setNotification(FriendRequestsPanel.listSize, FriendsPanel.notification);
				}
				catch (Exception e){
					
				}
			}else {
				FriendRequestsPanel.listSize = 0;
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static Integer getFriendshipIdFromSelected() { 		//We need Friendship Id to remove request
		Integer wantedFriendshipID = 0;
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "select idFriendship from giftyDB.friendships where requestReceiver = '"+Login.userID+"' "
					+ "and requestSender = '"+FriendRequestsPanel.selectedFriendUserId+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()){
					
				wantedFriendshipID = rs.getInt("idFriendship");
				
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
		
		return wantedFriendshipID;
	}
	
	public static void acceptFriendRequest() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
		
			String sql = "UPDATE giftyDB.friendships SET statusReceiver = 1 "
					+ "WHERE requestReceiver = '"+Login.userID+"' and requestSender = '"+FriendRequestsPanel.selectedFriendUserId+"';";
			
			stmt.execute(sql);
			
			stmt.close();
			con.close();
			
			loadRequestList();
			
			loadFriendList();
			Sidebar.menuClicked(HomePage.friendRequestsPanel);
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static void removeFriendRequest() {

		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
		
			String sql = "Delete from friendships where idFriendship = '"+getFriendshipIdFromSelected()+"'";
			
			stmt.execute(sql);
			
			stmt.close();
			con.close();
			
			loadRequestList();
			Sidebar.menuClicked(HomePage.friendRequestsPanel);
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static void getDataFromSelectedRequest() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "select idUser from giftyDB.users where username = '"+FriendRequestsPanel.selectedUser+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()){
					
				FriendRequestsPanel.selectedFriendUserId = rs.getString("idUser");

			}
			
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
		
	}
	
	//Friends Profile Methods
	
	public static void loadFriendsWishlist() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "select itemName from giftyDB.wishlist where idUser = '"+FriendsListPanel.selectedFriendUserId+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			DefaultListModel<String> DLM = new DefaultListModel<String>();
			while (rs.next()){
				
				DLM.addElement(rs.getString("itemName"));
				
			}
			
			FriendsProfilePanel.friendsWishlist.setModel(DLM);
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static void getDataFromSelectedFriendsItem() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "select * from giftyDB.wishlist where itemName = '"+FriendsProfilePanel.selectedItem+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()){
					
				FriendsProfilePanel.itemId = rs.getString("idWishlistItem");
				FriendsProfilePanel.itemName = rs.getString("itemName");
				FriendsProfilePanel.itemPrice = rs.getString("itemPrice");
				FriendsProfilePanel.itemLink = rs.getString("itemLink");
				FriendsProfilePanel.itemCurrency = rs.getString("itemCurrency");
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
		
	}
	
}
