package methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import gifty.CalendarPanel;
import gifty.DBConnection;
import gifty.Login;

public class CalendarMethods {
	private void getAllDates() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "SELECT dateOfBirth from giftyDB.friendships inner join giftyDB.users\n" + 
					"on giftyDB.users.idUser = giftyDB.friendships.requestReceiver or\n" + 
					"giftyDB.users.idUser = giftyDB.friendships.requestSender\n" + 
					"where (requestReceiver = '"+Login.userID+"' or requestSender = '"+Login.userID+"')"
							+ "and statusReceiver = 1 and statusSender = 1 "
							+ "and not username = '"+Login.userUsername+"' ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			CalendarPanel.datesListDLM = new DefaultListModel<String>();
			
			while (rs.next()){
					
				CalendarPanel.datesListDLM.addElement(rs.getString("username"));
				
			}
			
			CalendarPanel.datesList.setModel(CalendarPanel.datesListDLM);
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
}
