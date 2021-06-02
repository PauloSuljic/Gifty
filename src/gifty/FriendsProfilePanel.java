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

import methods.FriendMethods;

import javax.swing.JScrollPane;

@SuppressWarnings("serial")

public class FriendsProfilePanel extends JPanel {
	
	public static JList<String> friendsWishlist;
	
	static Color primaryColor = new Color(100, 149, 237);
	static Color secondColor = new Color(65, 105, 225);
	
	public static String selectedItem;
	
	public static String itemId;
	public static String itemName;
	public static String itemPrice;
	public static String itemLink;
	public static String itemCurrency;
	
	protected static JLabel friendsListLabel;
	protected static JLabel fullName;
	protected static JLabel username;
	protected static JLabel email;
	protected static JLabel giftyId;
	protected static JLabel friendsBirthday;
	private JScrollPane scrollPane;
	
	public FriendsProfilePanel() {
		
		setLayout(null);
		setBounds(137, 148, 733, 349);
		setBackground(new Color(100, 149, 237));
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 12, 350, 313);
		panel.setBorder(new LineBorder(new Color(65, 105, 225), 5));
		panel.setBackground(new Color(65, 105, 225));
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(407, 12, 297, 313);
		panel2.setBorder(null);
		panel2.setBackground(new Color(65, 105, 225));
		
		JButton openLinkButton = new JButton("Open Link");
		openLinkButton.setBounds(94, 276, 108, 29);
		openLinkButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(friendsWishlist.getSelectedValue() != null) {
					selectedItem = friendsWishlist.getSelectedValue();
					FriendMethods.getDataFromSelectedFriendsItem();
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
		
		
		friendsListLabel = new JLabel("");
		friendsListLabel.setBounds(6, 20, 285, 38);
		friendsListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		friendsListLabel.setForeground(Color.WHITE);
		friendsListLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
			
		fullName = new JLabel((String) null);
		fullName.setBounds(11, 20, 333, 38);
		fullName.setHorizontalAlignment(SwingConstants.CENTER);
		fullName.setForeground(Color.WHITE);
		fullName.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(11, 78, 105, 38);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		username = new JLabel((String) null);
		username.setBounds(128, 78, 216, 38);
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(11, 136, 105, 38);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		email = new JLabel((String) null);
		email.setBounds(128, 136, 216, 38);
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Helvetica", Font.PLAIN, 15));
			
		JLabel giftyIdLabel = new JLabel("Gifty ID: ");
		giftyIdLabel.setBounds(11, 194, 105, 38);
		giftyIdLabel.setForeground(Color.WHITE);
		giftyIdLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		giftyId = new JLabel((String) null);
		giftyId.setBounds(128, 194, 216, 38);
		giftyId.setForeground(Color.WHITE);
		giftyId.setFont(new Font("Helvetica", Font.PLAIN, 15));
			
		JLabel birthdayLabel = new JLabel("Birthday:");
		birthdayLabel.setBounds(11, 252, 105, 38);
		birthdayLabel.setForeground(Color.WHITE);
		birthdayLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		friendsBirthday = new JLabel((String) null);
		friendsBirthday.setBounds(128, 252, 216, 38);
		friendsBirthday.setForeground(Color.WHITE);
		friendsBirthday.setFont(new Font("Helvetica", Font.PLAIN, 15));

		add(panel);
		panel.setLayout(null);
		panel.add(fullName);
		panel.add(birthdayLabel);
		panel.add(friendsBirthday);
		panel.add(giftyIdLabel);
		panel.add(giftyId);
		panel.add(emailLabel);
		panel.add(email);
		panel.add(usernameLabel);
		panel.add(username);
		
		add(panel2);
		panel2.setLayout(null);
		panel2.add(friendsListLabel);
		panel2.add(openLinkButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 70, 231, 194);
		panel2.add(scrollPane);
		
		friendsWishlist = new JList<String>();
		scrollPane.setViewportView(friendsWishlist);
		friendsWishlist.setSelectionBackground(new Color(100, 149, 237));
		friendsWishlist.setForeground(Color.WHITE);
		friendsWishlist.setFont(new Font("Helvetica", Font.PLAIN, 12));
		friendsWishlist.setFixedCellWidth(100);
		friendsWishlist.setFixedCellHeight(30);
		friendsWishlist.setBorder(new LineBorder(new Color(65, 105, 225), 5));
		friendsWishlist.setBackground(new Color(65, 105, 225));
		
		//loadWishlist();
	
	}

}
