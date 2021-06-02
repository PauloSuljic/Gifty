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
public class FriendsPanel extends JPanel {
	
	public static JLabel notification;
	
	public FriendsPanel() {

		setLayout(null);
		setBounds(137, 148, 730, 349);
		setBackground(new Color(100, 149, 237));
		
		//Images from source file
		Image imgAddNewFriend = new ImageIcon(this.getClass().getResource("/add-friend.png")).getImage();
		Image imgFriendsList = new ImageIcon(this.getClass().getResource("/friends.png")).getImage();
		Image imgFriendRequests = new ImageIcon(this.getClass().getResource("/networking.png")).getImage();
		
		JPanel friendsListPanel = new JPanel();
		friendsListPanel.setBounds(393, 26, 307, 130);
		friendsListPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		friendsListPanel.setBackground(new Color(65, 105, 225));
		friendsListPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.friendsListPanel);
			}
		});
		
		
		JPanel friendListIconPanel = new JPanel();
		friendListIconPanel.setBounds(6, 6, 120, 122);
		friendListIconPanel.setBackground(new Color(65, 105, 225));
		
		JLabel friendsListIcon = new JLabel("");
		friendsListIcon.setBounds(6, 6, 108, 110);
		friendsListIcon.setHorizontalAlignment(SwingConstants.CENTER);
		friendsListIcon.setIcon(new ImageIcon(imgFriendsList));
		
		JPanel friendListTextPanel = new JPanel();
		friendListTextPanel.setBounds(132, 6, 169, 122);
		friendListTextPanel.setBackground(new Color(65, 105, 225));
		
		JTextArea friendsListText = new JTextArea();
		friendsListText.setBounds(6, 52, 163, 67);
		friendsListText.setWrapStyleWord(true);
		friendsListText.setText("View list of all your friends");
		friendsListText.setLineWrap(true);
		friendsListText.setForeground(Color.WHITE);
		friendsListText.setFont(new Font("Helvetica", Font.PLAIN, 10));
		friendsListText.setEditable(false);
		friendsListText.setBackground(new Color(65, 105, 225));
		
		JLabel friendsListTitle = new JLabel("Friends List");
		friendsListTitle.setBounds(6, 0, 163, 46);
		friendsListTitle.setForeground(Color.WHITE);
		friendsListTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
	
		
		JPanel addFriendPanel = new JPanel();
		addFriendPanel.setBounds(208, 189, 307, 130);
		addFriendPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addFriendPanel.setBackground(new Color(65, 105, 225));
		addFriendPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.addNewFriendPanel);
			}
		});
		
		
		JPanel addNewIconPanel = new JPanel();
		addNewIconPanel.setBounds(6, 6, 125, 121);
		addNewIconPanel.setBackground(new Color(65, 105, 225));
		
		JLabel addFriendIcon = new JLabel("");
		addFriendIcon.setBounds(6, 6, 113, 109);
		addFriendIcon.setHorizontalAlignment(SwingConstants.CENTER);
		addFriendIcon.setIcon(new ImageIcon(imgAddNewFriend));
		
		JPanel addNewTextPanel = new JPanel();
		addNewTextPanel.setBounds(137, 6, 164, 121);
		addNewTextPanel.setBackground(new Color(65, 105, 225));
		
		JTextArea addFriendsText = new JTextArea();
		addFriendsText.setBounds(6, 63, 154, 52);
		addFriendsText.setWrapStyleWord(true);
		addFriendsText.setText("Find and add new friends");
		addFriendsText.setLineWrap(true);
		addFriendsText.setForeground(Color.WHITE);
		addFriendsText.setFont(new Font("Helvetica", Font.PLAIN, 10));
		addFriendsText.setEditable(false);
		addFriendsText.setBackground(new Color(65, 105, 225));
		
		JLabel addFriendTitle = new JLabel("Add New Friend");
		addFriendTitle.setBounds(6, 6, 154, 45);
		addFriendTitle.setForeground(Color.WHITE);
		addFriendTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
		
		JPanel friendRequestPanel = new JPanel();
		friendRequestPanel.setBounds(28, 26, 307, 130);
		friendRequestPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		friendRequestPanel.setBackground(new Color(65, 105, 225));
		friendRequestPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sidebar.menuClicked(HomePage.friendRequestsPanel);
			}
		});
		
		
		JPanel friendRequestsIconPanel = new JPanel();
		friendRequestsIconPanel.setBounds(6, 6, 120, 118);
		friendRequestsIconPanel.setBackground(new Color(65, 105, 225));
		
		JLabel friendRequestIcon = new JLabel("");
		friendRequestIcon.setBounds(6, 6, 108, 106);
		friendRequestIcon.setHorizontalAlignment(SwingConstants.CENTER);
		friendRequestIcon.setIcon(new ImageIcon(imgFriendRequests));
		
		JPanel friendRequestTextPanel = new JPanel();
		friendRequestTextPanel.setBounds(130, 6, 171, 118);
		friendRequestTextPanel.setBackground(new Color(65, 105, 225));
		
		JTextArea friendRequestText = new JTextArea();
		friendRequestText.setBounds(6, 49, 159, 63);
		friendRequestText.setWrapStyleWord(true);
		friendRequestText.setText("Find out who wants to be friend with you");
		friendRequestText.setLineWrap(true);
		friendRequestText.setForeground(Color.WHITE);
		friendRequestText.setFont(new Font("Helvetica", Font.PLAIN, 10));
		friendRequestText.setEditable(false);
		friendRequestText.setBackground(new Color(65, 105, 225));
		
		JLabel friendRequestsTitle = new JLabel("Friend Requests");
		friendRequestsTitle.setBounds(6, 6, 159, 31);
		friendRequestsTitle.setForeground(Color.WHITE);
		friendRequestsTitle.setFont(new Font("Helvetica", Font.BOLD, 15));
		
		add(friendRequestPanel);
		
		friendRequestPanel.setLayout(null);
		friendRequestPanel.add(friendRequestsIconPanel);
		
		friendRequestsIconPanel.setLayout(null);
		friendRequestsIconPanel.add(friendRequestIcon);
		
		friendRequestPanel.add(friendRequestTextPanel);
		
		friendRequestTextPanel.setLayout(null);
		friendRequestTextPanel.add(friendRequestText);
		friendRequestTextPanel.add(friendRequestsTitle);
		
		add(friendsListPanel);
		
		friendsListPanel.setLayout(null);
		friendsListPanel.add(friendListIconPanel);
		
		friendListIconPanel.setLayout(null);
		friendListIconPanel.add(friendsListIcon);
		
		friendsListPanel.add(friendListTextPanel);
		
		friendListTextPanel.setLayout(null);
		friendListTextPanel.add(friendsListText);
		friendListTextPanel.add(friendsListTitle);
		
		add(addFriendPanel);
		
		addFriendPanel.setLayout(null);
		addFriendPanel.add(addNewIconPanel);
		
		addNewIconPanel.setLayout(null);
		addNewIconPanel.add(addFriendIcon);
		
		addFriendPanel.add(addNewTextPanel);
		
		addNewTextPanel.setLayout(null);
		addNewTextPanel.add(addFriendsText);
		addNewTextPanel.add(addFriendTitle);
		
		notification = new JLabel("");
		notification.setHorizontalAlignment(SwingConstants.CENTER);
		notification.setForeground(new Color(255, 0, 0));
		notification.setFont(new Font("Helvetica", Font.BOLD, 20));
		notification.setBounds(146, 6, 19, 17);
		
		friendRequestTextPanel.add(notification);
		
		FriendMethods.setNotification(FriendRequestsPanel.listSize, notification);
		
	}
}
