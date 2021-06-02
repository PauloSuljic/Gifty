package gifty;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JPanel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")

public class HomePage extends JFrame {
	
	public static FriendRequestsPanel friendRequestsPanel;
	protected static HomePanel homePanel;
	protected static MyProfilePanel myProfilePanel;
	
	protected static FriendsPanel friendsPanel;
	public static WishlistPanel wishlistPanel;
	protected static FriendsListPanel friendsListPanel;
	protected static FriendsProfilePanel friendsProfilePanel;
	
	protected static AddNewFriendPanel addNewFriendPanel;
	protected static AddNewItemPanel addNewItemPanel;
	protected static CalendarPanel calendarPanel;
	
	protected static Settings settings;
	
	private JPanel panel;
	

	public HomePage() {
		setResizable(false);
		getContentPane().setBackground(new Color(100, 149, 237));
		getContentPane().setLayout(null);
		setBounds(100, 100, 870, 525);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Title
		JLabel title = new JLabel("Gifty");
		title.setBounds(137, 6, 733, 136);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Snell Roundhand", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		Sidebar sidebar = new Sidebar();
		
		friendRequestsPanel = new FriendRequestsPanel();
		homePanel = new HomePanel();
		myProfilePanel = new MyProfilePanel();
		
		friendsPanel = new FriendsPanel();
		wishlistPanel = new WishlistPanel();
		friendsListPanel = new FriendsListPanel();
		friendsProfilePanel = new FriendsProfilePanel();
		
		addNewFriendPanel = new AddNewFriendPanel();
		addNewItemPanel = new AddNewItemPanel();
		calendarPanel = new CalendarPanel();
		
		settings = new Settings();
		
		panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(0, 427, 135, 76);
		panel.setLayout(null);
		
		getContentPane().add(title);
		getContentPane().add(sidebar);
		getContentPane().add(friendRequestsPanel);
		getContentPane().add(homePanel);
		getContentPane().add(myProfilePanel);
		getContentPane().add(friendsPanel);
		getContentPane().add(wishlistPanel);
		getContentPane().add(friendsListPanel);
		getContentPane().add(friendsProfilePanel);
		
		getContentPane().add(addNewFriendPanel);
		getContentPane().add(addNewItemPanel);
		getContentPane().add(calendarPanel);
		getContentPane().add(settings);
		
		getContentPane().add(panel);
		
		Sidebar.menuClicked(homePanel);
		
		//Logout link
		JLabel logoutSidebar = new JLabel("Logout");
		logoutSidebar.setBounds(22, 33, 107, 26);
		logoutSidebar.setBackground(new Color(65, 105, 225));
		logoutSidebar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutSidebar.setForeground(Color.WHITE);
		logoutSidebar.setFont(new Font("Helvetica", Font.PLAIN, 13));
		logoutSidebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login.userID = null;
				Login.userUsername = null;
				Login.userDateOfBirth = null;
				Login.userEmail = null;
				
				Login login = new Login();
				login.setLocationRelativeTo(null);
				login.setVisible(true);
			}
		});
		
		JLabel settingsSidebar = new JLabel("Settings");
		settingsSidebar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		settingsSidebar.setForeground(Color.WHITE);
		settingsSidebar.setFont(new Font("Helvetica", Font.PLAIN, 13));
		settingsSidebar.setBackground(new Color(65, 105, 225));
		settingsSidebar.setBounds(22, 6, 107, 26);
		settingsSidebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.settings);
			}
		});
		
		panel.add(logoutSidebar);
		panel.add(settingsSidebar);
		
	}
	
}
