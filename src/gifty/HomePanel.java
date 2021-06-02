package gifty;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import methods.FriendMethods;

@SuppressWarnings("serial")

public class HomePanel extends JPanel {
	
	public static JLabel notification;
	static Integer listSize;
	
	public HomePanel() {
		
		setLayout(null);
		setBounds(137, 148, 733, 349);
		setBackground(new Color(100, 149, 237));
		
		Image imgProfileIcon = new ImageIcon(this.getClass().getResource("/profile-user.png")).getImage();
		Image imgFriends = new ImageIcon(this.getClass().getResource("/friends.png")).getImage();
		Image imgCalendar = new ImageIcon(this.getClass().getResource("/calendar.png")).getImage();
		Image imgWishlist = new ImageIcon(this.getClass().getResource("/wishlist.png")).getImage();
		
		//Friends Button
		JPanel friendsButton = new JPanel();
		friendsButton.setBounds(35, 18, 316, 136);
		friendsButton.setBackground(new Color(65, 105, 225));
		friendsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		friendsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.friendsPanel);
			}
		});
		
		JPanel friendsIconPanel = new JPanel();
		friendsIconPanel.setBounds(6, 6, 128, 122);
		friendsIconPanel.setBackground(new Color(65, 105, 225));
		
		JLabel friendsIcon = new JLabel("");
		friendsIcon.setBounds(6, 6, 116, 110);
		friendsIcon.setHorizontalAlignment(SwingConstants.CENTER);
		friendsIcon.setIcon(new ImageIcon(imgFriends));
		
		JPanel friendsTextPanel = new JPanel();
		friendsTextPanel.setBounds(138, 6, 170, 122);
		friendsTextPanel.setBackground(new Color(65, 105, 225));
		
		JTextArea friendsText = new JTextArea();
		friendsText.setBounds(6, 57, 158, 59);
		friendsText.setWrapStyleWord(true);
		friendsText.setText("View all of your friends or add a new one");
		friendsText.setLineWrap(true);
		friendsText.setForeground(Color.WHITE);
		friendsText.setFont(new Font("Helvetica", Font.PLAIN, 10));
		friendsText.setEditable(false);
		friendsText.setBackground(new Color(65, 105, 225));
		
		JLabel friendsTitle = new JLabel("Friends");
		friendsTitle.setBounds(6, 6, 182, 39);
		friendsTitle.setForeground(Color.WHITE);
		friendsTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
		friendsTitle.setEnabled(true);
		
		
		//MyProfile Button
		JPanel myProfileButton = new JPanel();
		myProfileButton.setBounds(378, 18, 316, 136);
		myProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		myProfileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.myProfilePanel);
			}
		});
		myProfileButton.setBackground(new Color(65, 105, 225));
		
		JPanel myProfileIconPanel = new JPanel();
		myProfileIconPanel.setBounds(6, 6, 128, 124);
		myProfileIconPanel.setBackground(new Color(65, 105, 225));
		
		JLabel myProfileIcon = new JLabel("");
		myProfileIcon.setBounds(6, 6, 116, 112);
		myProfileIcon.setIcon(new ImageIcon(imgProfileIcon));
		myProfileIcon.setForeground(new Color(255, 255, 255));
		myProfileIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel myProfileTextPanel = new JPanel();
		myProfileTextPanel.setBounds(138, 6, 170, 124);
		myProfileTextPanel.setBackground(new Color(65, 105, 225));
		
		JLabel myProfileTitle = new JLabel("My Profile");
		myProfileTitle.setBounds(6, 6, 158, 40);
		myProfileTitle.setForeground(new Color(255, 255, 255));
		myProfileTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
		myProfileTitle.setHorizontalAlignment(SwingConstants.LEADING);
		myProfileTitle.setEnabled(true);
		
		JTextArea myProfileText = new JTextArea();
		myProfileText.setBounds(6, 58, 158, 60);
		myProfileText.setWrapStyleWord(true);
		myProfileText.setLineWrap(true);
		myProfileText.setFont(new Font("Helvetica", Font.PLAIN, 10));
		myProfileText.setBackground(new Color(65, 105, 225));
		myProfileText.setForeground(new Color(255, 255, 255));
		myProfileText.setText("View and edit your profile info");
		myProfileText.setEditable(false);
		
		//Groups Button
		JPanel groupsButton = new JPanel();
		groupsButton.setBounds(35, 184, 316, 136);
		groupsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		groupsButton.setBackground(new Color(65, 105, 225));
		groupsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.calendarPanel);
			}
		});
		
		JPanel groupsIconPanel = new JPanel();
		groupsIconPanel.setBounds(6, 6, 128, 124);
		groupsIconPanel.setBackground(new Color(65, 105, 225));
		
		JLabel groupsIcon = new JLabel("");
		groupsIcon.setBounds(6, 6, 116, 112);
		groupsIcon.setIcon(new ImageIcon(imgCalendar));
		groupsIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel groupsTextPanel = new JPanel();
		groupsTextPanel.setBounds(138, 6, 172, 124);
		groupsTextPanel.setBackground(new Color(65, 105, 225));
		
		JLabel groupsTitle = new JLabel("Calendar");
		groupsTitle.setBounds(6, 6, 160, 40);
		groupsTitle.setForeground(new Color(255, 255, 255));
		groupsTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
		
		JTextArea groupsText = new JTextArea();
		groupsText.setBounds(6, 58, 160, 60);
		groupsText.setText("Check upcoming birthdays of your friends");
		groupsText.setForeground(new Color(255, 255, 255));
		groupsText.setBackground(new Color(65, 105, 225));
		groupsText.setLineWrap(true);
		groupsText.setWrapStyleWord(true);
		groupsText.setEditable(false);
		groupsText.setFont(new Font("Helvetica", Font.PLAIN, 10));
		
		//Wishlist Button
		JPanel wishlistButton = new JPanel();
		wishlistButton.setBounds(378, 184, 316, 136);
		wishlistButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wishlistButton.setBackground(new Color(65, 105, 225));
		wishlistButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.wishlistPanel);
			}
		});
		
		JPanel wishlistIconPanel = new JPanel();
		wishlistIconPanel.setBounds(6, 6, 128, 124);
		wishlistIconPanel.setBackground(new Color(65, 105, 225));
		
		JLabel wishlistIcon = new JLabel("");
		wishlistIcon.setBounds(6, 6, 116, 112);
		wishlistIcon.setIcon(new ImageIcon(imgWishlist));
		wishlistIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel wishlistTextPanel = new JPanel();
		wishlistTextPanel.setBounds(138, 6, 170, 124);
		wishlistTextPanel.setBackground(new Color(65, 105, 225));
		
		JLabel wishlistTitle = new JLabel("Wishlist");
		wishlistTitle.setBounds(6, 6, 158, 40);
		wishlistTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
		wishlistTitle.setEnabled(true);
		wishlistTitle.setForeground(new Color(255, 255, 255));
		
		JTextArea wishlistText = new JTextArea();
		wishlistText.setBounds(6, 58, 158, 60);
		wishlistText.setEditable(false);
		wishlistText.setFont(new Font("Helvetica", Font.PLAIN, 10));
		wishlistText.setForeground(new Color(255, 255, 255));
		wishlistText.setText("Add and remove items from your wishlist");
		wishlistText.setLineWrap(true);
		wishlistText.setWrapStyleWord(true);
		wishlistText.setBackground(new Color(65, 105, 225));
		
		friendsButton.setLayout(null);
		friendsButton.add(friendsIconPanel);
		friendsIconPanel.setLayout(null);
		friendsIconPanel.add(friendsIcon);
		friendsButton.add(friendsTextPanel);
		friendsTextPanel.setLayout(null);
		friendsTextPanel.add(friendsText);
		friendsTextPanel.add(friendsTitle);
		
		notification = new JLabel("");
		notification.setBounds(145, 6, 19, 17);
		notification.setHorizontalAlignment(SwingConstants.CENTER);
		notification.setForeground(new Color(255, 0, 0));
		notification.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		friendsTextPanel.add(notification);
		
		myProfileButton.setLayout(null);
		myProfileButton.add(myProfileIconPanel);
		myProfileIconPanel.setLayout(null);
		myProfileIconPanel.add(myProfileIcon);
		myProfileButton.add(myProfileTextPanel);
		myProfileTextPanel.setLayout(null);
		myProfileTextPanel.add(myProfileText);
		myProfileTextPanel.add(myProfileTitle);
		
		groupsButton.setLayout(null);
		groupsButton.add(groupsIconPanel);
		groupsIconPanel.setLayout(null);
		groupsIconPanel.add(groupsIcon);
		groupsButton.add(groupsTextPanel);
		groupsTextPanel.setLayout(null);
		groupsTextPanel.add(groupsText);
		groupsTextPanel.add(groupsTitle);
		
		wishlistButton.setLayout(null);
		wishlistButton.add(wishlistIconPanel);
		wishlistIconPanel.setLayout(null);
		wishlistIconPanel.add(wishlistIcon);
		wishlistButton.add(wishlistTextPanel);
		wishlistTextPanel.setLayout(null);
		wishlistTextPanel.add(wishlistText);
		wishlistTextPanel.add(wishlistTitle);
		
		add(friendsButton);
		add(myProfileButton);
		add(groupsButton);
		add(wishlistButton);
		
		FriendMethods.setNotification(FriendRequestsPanel.listSize, notification);
		
	}

}
