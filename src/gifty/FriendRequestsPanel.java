package gifty;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
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
public class FriendRequestsPanel extends JPanel {
		
	public static JList<String> requestList;
	
	public static Integer listSize;
	
	public static String selectedUser;

	public static String selectedFriendUserId;

	public static DefaultListModel<String> requestListDLM;
		
	public FriendRequestsPanel() {
		setLayout(null);
		setBounds(137, 148, 733, 349);
		setBackground(new Color(100, 149, 237));
		
		JPanel panel = new JPanel();
		panel.setBounds(185, 12, 363, 325);
		panel.setBackground(new Color(65, 105, 225));
		
		JLabel lblFriendRequests = new JLabel("Friend requests");
		lblFriendRequests.setBounds(6, 20, 351, 38);
		lblFriendRequests.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriendRequests.setForeground(Color.WHITE);
		lblFriendRequests.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		JButton acceptRequestButton = new JButton("Accept");
		acceptRequestButton.setBounds(49, 290, 123, 29);
		acceptRequestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(requestList.getSelectedValue() != null) {
					selectedUser = requestList.getSelectedValue();
					FriendMethods.getDataFromSelectedRequest();
					FriendMethods.acceptFriendRequest();
					JOptionPane.showMessageDialog(null, "You and '"+selectedUser+"' are now friends!");
				}else {
					JOptionPane.showMessageDialog(null, "No user selected");
				}
			}
		});
		
		JButton removeRequestButton = new JButton("Remove");
		removeRequestButton.setBounds(196, 290, 122, 29);
		removeRequestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(requestList.getSelectedValue() != null) {
					selectedUser = requestList.getSelectedValue();
					FriendMethods.getDataFromSelectedRequest();
					FriendMethods.removeFriendRequest();
					JOptionPane.showMessageDialog(null, "You removed a request from '"+selectedUser+"' ");
				}else {
					JOptionPane.showMessageDialog(null, "No user selected");
				}
			}
		});
		
		add(panel);
		panel.setLayout(null);
		panel.add(acceptRequestButton);
		panel.add(removeRequestButton);
		panel.add(lblFriendRequests);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 74, 254, 200);
		panel.add(scrollPane);
		
		requestList = new JList<String>();
		scrollPane.setViewportView(requestList);
		requestList.setSelectionBackground(new Color(100, 149, 237));
		requestList.setForeground(Color.WHITE);
		requestList.setFixedCellWidth(100);
		requestList.setFixedCellHeight(30);
		requestList.setBorder(new LineBorder(new Color(65, 105, 225), 5));
		requestList.setBackground(new Color(65, 105, 225));
		
		FriendMethods.loadRequestList();
	}
}
