package gifty;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import methods.SettingsMethods;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Settings extends JPanel {
	private JPasswordField oldPasswordText;
	public static JPasswordField newPasswordText;
	
	public static ArrayList<Integer> friendships;
	public static ArrayList<Integer> wishlistItems;
	
	//protected static DefaultListModel<Integer> friendshipsDLM;

	public Settings() {
		setLayout(null);
		setBounds(137, 148, 733, 349);
		setBackground(new Color(100, 149, 237));
		
		JPanel panel = new JPanel();
		panel.setBounds(185, 12, 363, 325);
		panel.setBackground(new Color(65, 105, 225));
		
		JLabel settingsLabel = new JLabel("Settings");
		settingsLabel.setBounds(6, 20, 351, 38);
		settingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		settingsLabel.setForeground(Color.WHITE);
		settingsLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		add(panel);
		panel.add(settingsLabel);
		panel.setLayout(null);
		
		JLabel changePassLabel = new JLabel("Change password");
		changePassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		changePassLabel.setForeground(Color.WHITE);
		changePassLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		changePassLabel.setBounds(6, 89, 351, 28);
		panel.add(changePassLabel);
		
		JLabel deleteAccLabel = new JLabel("Delete my account");
		deleteAccLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		deleteAccLabel.setForeground(Color.WHITE);
		deleteAccLabel.setFont(new Font("Helvetica", Font.PLAIN, 12));
		deleteAccLabel.setBounds(6, 274, 171, 28);
		panel.add(deleteAccLabel);
		
		JButton deleteAccountButton = new JButton("Delete");
		deleteAccountButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		deleteAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Select option", JOptionPane.YES_NO_CANCEL_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					SettingsMethods.getFriendshipIds();
					SettingsMethods.deleteFriendships();
					
					SettingsMethods.getWishlistItemIds();
					SettingsMethods.deleteWishlist();
					
					SettingsMethods.deleteAccount();
				}
			}
		});
		deleteAccountButton.setBounds(189, 274, 84, 29);
		panel.add(deleteAccountButton);
		
		oldPasswordText = new JPasswordField();
		oldPasswordText.setBounds(161, 129, 152, 28);
		panel.add(oldPasswordText);
		
		newPasswordText = new JPasswordField();
		newPasswordText.setBounds(161, 169, 152, 28);
		panel.add(newPasswordText);
		
		friendships = new ArrayList<Integer>();
		
		JLabel oldPasswordLabel = new JLabel("Old password");
		oldPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oldPasswordLabel.setForeground(new Color(255, 255, 255));
		oldPasswordLabel.setBounds(50, 129, 99, 28);
		panel.add(oldPasswordLabel);
		
		JLabel newPasswordLabel = new JLabel("New password");
		newPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newPasswordLabel.setForeground(Color.WHITE);
		newPasswordLabel.setBounds(50, 169, 99, 28);
		panel.add(newPasswordLabel);
		
		JButton saveNewPassButton = new JButton("Save");
		saveNewPassButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		saveNewPassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oldPasswordText.getText().equals(Login.password.getText())) {
					SettingsMethods.changePassword();
				}else {
					JOptionPane.showMessageDialog(null, "Enter correct password");
				}
			}
		});
	
		saveNewPassButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		saveNewPassButton.setBounds(238, 201, 75, 29);
		panel.add(saveNewPassButton);
	}
}
