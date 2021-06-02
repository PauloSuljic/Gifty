package gifty;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import methods.FriendMethods;

@SuppressWarnings("serial")
public class AddNewFriendPanel extends JPanel {
	
public static JList<String> sentRequestList;
public static JPanel panel;
public static JLabel username;
	
	public static String usernameOutput;
	public static JTextField enterId;
	
	public static DefaultListModel<String> friendsListDLM;
	public static DefaultListModel<String> sentRequestListDLM;
	
	public AddNewFriendPanel() {
		
		setLayout(null);
		setBounds(137, 148, 730, 349);
		setBackground(new Color(100, 149, 237));
		
		JPanel mainSection = new JPanel();
		mainSection.setBounds(183, 12, 363, 325);
		mainSection.setBackground(new Color(65, 105, 225));
		
		panel = new JPanel();
		panel.setBounds(6, 177, 351, 148);
		panel.setBackground(new Color(65, 105, 225));
		panel.setVisible(false);
		
		username = new JLabel("");
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Helvetica", Font.PLAIN, 24));
		username.setBounds(6, 58, 339, 30);
		panel.add(username);
		
		JButton sendRequestButton = new JButton("Send Request");
		sendRequestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FriendMethods.sendRequest();
			}
		});
		sendRequestButton.setBounds(102, 100, 146, 30);
		panel.add(sendRequestButton);
		
		enterId = new JTextField();
		enterId.setBounds(197, 81, 104, 35);
		enterId.setColumns(10);
		
		JLabel enterIdLabel = new JLabel("Enter Gifty ID");
		enterIdLabel.setBounds(84, 81, 95, 35);
		enterIdLabel.setForeground(Color.WHITE);
		
		JButton addFriendButton = new JButton("Search");
		addFriendButton.setBounds(139, 136, 85, 29);
		addFriendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FriendMethods.searchFriend();
			}
		});
		
		JLabel addNewFriendLabel = new JLabel("Add New Friend");
		addNewFriendLabel.setBounds(6, 20, 351, 38);
		addNewFriendLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addNewFriendLabel.setForeground(Color.WHITE);
		addNewFriendLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		sentRequestList = new JList<String>();
		panel.setLayout(null);
		
		JLabel isThisLabel = new JLabel("Is this your friend?");
		isThisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		isThisLabel.setForeground(Color.WHITE);
		isThisLabel.setFont(new Font("Helvetica", Font.PLAIN, 14));
		isThisLabel.setBounds(6, 20, 339, 26);
		
		panel.add(isThisLabel);
		add(mainSection);
		mainSection.setLayout(null);
		mainSection.add(panel);
		mainSection.add(enterIdLabel);
		mainSection.add(enterId);
		mainSection.add(addFriendButton);
		mainSection.add(addNewFriendLabel);
		
		FriendMethods.loadFriendListAF();
		FriendMethods.loadSentRequestList();
	}

}
