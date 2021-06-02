package gifty;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import methods.FriendMethods;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class FriendsListPanel extends JPanel {
	
	public static String selectedUser;
	
	public static JList<String> nameList;
	
	public static String selectedFriendUsername;
	public static String selectedFriendEmail;
	public static String selectedFriendUserId;
	public static String selectedFriendFullname;
	public static Date selectedFriendBirthday;
	
	public static DefaultListModel<String> nameListDLM;
	
	public FriendsListPanel() {
		setLayout(null);
		setBounds(137, 148, 733, 349);
		setBackground(new Color(100, 149, 237));
		
		nameList = new JList<String>();
		nameList.setVisibleRowCount(6);
		nameList.setSelectionBackground(new Color(100, 149, 237));
		nameList.setForeground(Color.WHITE);
		nameList.setFont(new Font("Helvetica", Font.PLAIN, 12));
		nameList.setFixedCellWidth(100);
		nameList.setFixedCellHeight(30);
		nameList.setBorder(new LineBorder(new Color(65, 105, 225), 5));
		nameList.setBackground(new Color(65, 105, 225));
		

		JPanel panel = new JPanel();
		panel.setBounds(185, 12, 363, 325);
		panel.setBackground(new Color(65, 105, 225));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(54, 74, 254, 200);
		
		scrollPane.setViewportView(nameList);
		
		JButton viewProfileButton = new JButton("View Profile");
		viewProfileButton.setBounds(123, 290, 117, 29);
		viewProfileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nameList.getSelectedValue() != null) {
					selectedUser = nameList.getSelectedValue();
					FriendMethods.getDataFromSelectedFriend();
					Sidebar.menuClicked(HomePage.friendsProfilePanel);
					
					FriendsProfilePanel.friendsListLabel.setText(selectedFriendUsername + "'s Wishlist");
					FriendsProfilePanel.fullName.setText(FriendsListPanel.selectedFriendFullname);
					FriendsProfilePanel.username.setText(FriendsListPanel.selectedFriendUsername);
					FriendsProfilePanel.email.setText(FriendsListPanel.selectedFriendEmail);
					FriendsProfilePanel.giftyId.setText(FriendsListPanel.selectedFriendUserId);
					FriendsProfilePanel.friendsBirthday.setText(FriendsListPanel.selectedFriendBirthday.toString());
					
					FriendMethods.loadFriendsWishlist();
					
				}else {
					JOptionPane.showMessageDialog(null, "No user selected");
				}
				
			}
		});
		
		JLabel yourFriendsLabel = new JLabel("Your Friends");
		yourFriendsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yourFriendsLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		yourFriendsLabel.setForeground(new Color(255, 255, 255));
		yourFriendsLabel.setBounds(6, 20, 351, 42);

		add(panel);
		panel.add(yourFriendsLabel);
		panel.add(viewProfileButton);
		panel.add(scrollPane);

		FriendMethods.loadFriendList();
	}

}
