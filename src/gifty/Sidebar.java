package gifty;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import methods.SidebarMethods;


@SuppressWarnings("serial")
public class Sidebar extends JPanel {
		
	static JLabel userInicials;
	static JLabel dashboardSidebar;
	static JLabel myProfileSidebar;
	static JLabel friendsSidebar;
	static JLabel calendarSidebar;
	static JLabel wishlistSidebar;
	static JLabel logoutSidebar;
	
	public static void menuClicked(JPanel panel) {
		HomePage.homePanel.setVisible(false);
		HomePage.myProfilePanel.setVisible(false);
		HomePage.friendsPanel.setVisible(false);
		HomePage.wishlistPanel.setVisible(false);
		HomePage.friendsListPanel.setVisible(false);
		HomePage.friendsProfilePanel.setVisible(false);
		HomePage.friendRequestsPanel.setVisible(false);
		HomePage.addNewFriendPanel.setVisible(false);
		HomePage.addNewItemPanel.setVisible(false);
		HomePage.calendarPanel.setVisible(false);
		HomePage.settings.setVisible(false);
		
		panel.setVisible(true);
	}
		
	public Sidebar() {

		setBackground(new Color(65, 105, 225));
		setBounds(0, 0, 135, 430);
		setLayout(null);
		
		//Labels
		userInicials = new JLabel("");
		userInicials.setBounds(16, 6, 95, 147);
		userInicials.setForeground(new Color(255, 255, 255));
		userInicials.setBackground(new Color(255, 255, 255));
		userInicials.setFont(new Font("Helvetica", Font.PLAIN, 30));
		userInicials.setVerticalAlignment(SwingConstants.CENTER);
		userInicials.setHorizontalAlignment(SwingConstants.CENTER);
		userInicials.setEnabled(true);
	
		userInicials.setText(SidebarMethods.getInitials(Login.fullName));
		
		dashboardSidebar = new JLabel("Dashboard");
		dashboardSidebar.setBounds(16, 167, 95, 25);
		dashboardSidebar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dashboardSidebar.setFont(new Font("Helvetica", Font.PLAIN, 13));
		dashboardSidebar.setForeground(new Color(255, 255, 255));
		dashboardSidebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(HomePage.homePanel);	
			}
		});
		
		
		myProfileSidebar = new JLabel("My Profile");
		myProfileSidebar.setBounds(16, 193, 95, 25);
		myProfileSidebar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		myProfileSidebar.setFont(new Font("Helvetica", Font.PLAIN, 13));
		myProfileSidebar.setForeground(new Color(255, 255, 255));
		myProfileSidebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(HomePage.myProfilePanel);
				
			}
		});
		
		
		friendsSidebar = new JLabel("Friends");
		friendsSidebar.setBounds(16, 219, 95, 25);
		friendsSidebar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		friendsSidebar.setForeground(new Color(255, 255, 255));
		friendsSidebar.setFont(new Font("Helvetica", Font.PLAIN, 13));
		friendsSidebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(HomePage.friendsPanel);
			}
		});
		
		
		calendarSidebar = new JLabel("Calendar");
		calendarSidebar.setBounds(16, 245, 95, 25);
		calendarSidebar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarSidebar.setForeground(new Color(255, 255, 255));
		calendarSidebar.setFont(new Font("Helvetica", Font.PLAIN, 13));
		calendarSidebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.calendarPanel);
			}
		});
		
		wishlistSidebar = new JLabel("Wishlist");
		wishlistSidebar.setBounds(16, 271, 95, 25);
		wishlistSidebar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wishlistSidebar.setFont(new Font("Helvetica", Font.PLAIN, 13));
		wishlistSidebar.setForeground(new Color(255, 255, 255));
		wishlistSidebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(HomePage.wishlistPanel);
			}
		});
		
		add(userInicials);
		add(dashboardSidebar);
		add(myProfileSidebar);
		add(friendsSidebar);
		add(calendarSidebar);
		add(wishlistSidebar);
	}
	
}

