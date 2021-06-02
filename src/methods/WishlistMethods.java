package methods;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import gifty.AddNewItemPanel;
import gifty.DBConnection;
import gifty.HomePage;
import gifty.Login;
import gifty.Sidebar;
import gifty.WishlistPanel;

public class WishlistMethods {
	
	public static void loadWishlist() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "select itemName from giftyDB.wishlist where idUser = '"+Login.userID+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			DefaultListModel<String> DLM = new DefaultListModel<String>();
			while (rs.next()){
				
				DLM.addElement(rs.getString("itemName"));
				
			}
			
			WishlistPanel.wishlist.setModel(DLM);
			rs.close();
			stmt.close();
			con.close();
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static boolean URLValidation(String link) {
		try {
			new URL (link).openStream().close();
			return true;
		}catch (MalformedURLException e){
		}catch(IOException e){
		}
		return false;
	}
	
	public static void removeItem() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
		
			String sql = "Delete from wishlist where idWishlistItem = '"+WishlistPanel.itemId+"'";
			
			stmt.execute(sql);
			
			stmt.close();
			con.close();
			
			loadWishlist();
			Sidebar.menuClicked(HomePage.wishlistPanel);
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static void addNewItem() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			if ((AddNewItemPanel.itemNameTxt.getText().equals("")) || (AddNewItemPanel.itemLinkTxt.getText().equals("")) || (AddNewItemPanel.newItemCurrency.equals(""))
					|| (AddNewItemPanel.itemPriceTxt.getText().equals(""))){
				JOptionPane.showMessageDialog(null, "You must insert all the data");	
			}else {
				if (URLValidation(AddNewItemPanel.itemLinkTxt.getText())) {
					if(priceValidation(AddNewItemPanel.itemPriceTxt.getText())) {
						//Query
						Statement stmt=con.createStatement();
					
						String sql = "Insert into wishlist (itemName, itemLink, itemPrice, itemCurrency, idUser) "
								+ "values ('"+ AddNewItemPanel.itemNameTxt.getText() +"', "
								+ "'"+ AddNewItemPanel.itemLinkTxt.getText() +"', '"+ AddNewItemPanel.itemPriceTxt.getText() +"', "
								+ "'"+ AddNewItemPanel.newItemCurrency +"', '"+ Login.userID +"')";
						
						stmt.execute(sql);
						stmt.close();
						
						JOptionPane.showMessageDialog(null, "You added '"+AddNewItemPanel.itemNameTxt.getText()+"' to your wishlist");
						
						con.close();
						
						loadWishlist();
						Sidebar.menuClicked(HomePage.wishlistPanel);
					}else {
						JOptionPane.showMessageDialog(null, "Enter a valid price number");
					}
				}else {
					JOptionPane.showMessageDialog(null, "The link you entered is not valid");
				}
			}
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public static void getDataFromSelectedItem() {
		try {
			// Open connection
			Connection con = DBConnection.getDBConnection();
			
			//Query
			Statement stmt=con.createStatement();
			
			String sql = "select * from giftyDB.wishlist where itemName = '"+WishlistPanel.selectedItem+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()){
					
				WishlistPanel.itemId = rs.getString("idWishlistItem");
				WishlistPanel.itemName = rs.getString("itemName");
				WishlistPanel.itemPrice = rs.getString("itemPrice");
				WishlistPanel.itemLink = rs.getString("itemLink");
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2);
		}
		
	}
	
	public static boolean priceValidation(String s) {	
		try {
			Integer.parseInt(s); 
			return true;
		} catch (NumberFormatException e) {
			
		}
		return false;	
	}
	
	
}
