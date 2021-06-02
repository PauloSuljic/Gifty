package gifty;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import methods.WishlistMethods;

import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class WishlistPanel extends JPanel {
	
	public static JList<String> wishlist;
	
	public static String selectedItem;
	
	public static String itemId;
	public static String itemName;
	public static String itemPrice;
	public static String itemLink;
	protected static String itemCurrency;

	public WishlistPanel() {
		setLayout(null);
		setBounds(137, 148, 733, 349);
		setBackground(new Color(100, 149, 237));
		
		JPanel panel = new JPanel();
		panel.setBounds(185, 12, 363, 325);
		panel.setBackground(new Color(65, 105, 225));
		
		JLabel yourWishlistLabel = new JLabel("");
		yourWishlistLabel.setBounds(6, 20, 351, 38);
		yourWishlistLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yourWishlistLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		yourWishlistLabel.setForeground(new Color(255, 255, 255));
		yourWishlistLabel.setText("Your Wishlist:");
		
		JButton addNewItemButton = new JButton("Add New");
		addNewItemButton.setBounds(135, 289, 93, 29);
		addNewItemButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.addNewItemPanel);
			}
		});
		
		JButton openBrowserButton = new JButton("Open");
		openBrowserButton.setBounds(189, 254, 93, 29);
		openBrowserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(wishlist.getSelectedValue() != null) {
					selectedItem = wishlist.getSelectedValue();
					WishlistMethods.getDataFromSelectedItem();
					Desktop d = Desktop.getDesktop();
					try {
						d.browse(new URI(itemLink));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "No item selected");
				}
			}
		});
		
		JButton removeItemButton = new JButton("Remove");
		removeItemButton.setBounds(78, 254, 93, 29);
		removeItemButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(wishlist.getSelectedValue() != null) {
					selectedItem = wishlist.getSelectedValue();
					WishlistMethods.getDataFromSelectedItem();
					WishlistMethods.removeItem();
					JOptionPane.showMessageDialog(null, "You have removed '"+selectedItem+"' from wishlist");
				}else {
					JOptionPane.showMessageDialog(null, "No item selected");
				}
			}
		});
		
		add(panel);
		panel.setLayout(null);
		panel.add(addNewItemButton);
		panel.add(removeItemButton);
		panel.add(openBrowserButton);
		panel.add(yourWishlistLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 64, 254, 180);
		panel.add(scrollPane);
		
		
		wishlist = new JList<String>();
		scrollPane.setViewportView(wishlist);
		wishlist.setBorder(new LineBorder(new Color(65, 105, 225), 5));
		wishlist.setFont(new Font("Helvetica", Font.PLAIN, 12));
		wishlist.setBackground(new Color(65, 105, 225));
		wishlist.setForeground(new Color(255, 255, 255));
		wishlist.setFixedCellHeight(30);
		wishlist.setFixedCellWidth(100);
		wishlist.setSelectionBackground(FriendsProfilePanel.primaryColor);
		
		WishlistMethods.loadWishlist();
	}

}
