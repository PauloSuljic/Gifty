package gifty;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import methods.WishlistMethods;

@SuppressWarnings("serial")
public class AddNewItemPanel extends JPanel {
	
	public static String newItemCurrency = "";
	public static JTextField itemNameTxt;
	public static JTextField itemLinkTxt;
	public static JTextField itemPriceTxt;
	
	public AddNewItemPanel() {
		setLayout(null);
		setBounds(137, 148, 730, 349);
		setBackground(new Color(100, 149, 237));
		
		JPanel mainSection = new JPanel();
		mainSection.setBounds(3, 0, 724, 349);
		mainSection.setBackground(new Color(100, 149, 237));
		
		JPanel panel = new JPanel();
		panel.setBounds(200, 6, 324, 338);
		panel.setBackground(new Color(65, 105, 225));
		
		JLabel yourWishlistLabel = new JLabel("");
		yourWishlistLabel.setBounds(6, 18, 312, 38);
		yourWishlistLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yourWishlistLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		yourWishlistLabel.setForeground(new Color(255, 255, 255));
		yourWishlistLabel.setText("Add New Item");
		
		JLabel itemNameLabel = new JLabel("Item Name");
		itemNameLabel.setBounds(128, 70, 64, 13);
		itemNameLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		itemNameLabel.setForeground(new Color(255, 255, 255));
		
		itemNameTxt = new JTextField();
		itemNameTxt.setBounds(29, 86, 270, 26);
		itemNameTxt.setColumns(10);
		
		JLabel itemLinkLabel = new JLabel("Item Link");
		itemLinkLabel.setBounds(133, 127, 54, 13);
		itemLinkLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		itemLinkLabel.setForeground(new Color(255, 255, 255));
		
		JLabel itemPriceLabel = new JLabel("Price (approx.)");
		itemPriceLabel.setBounds(118, 185, 85, 13);
		itemPriceLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		itemPriceLabel.setForeground(new Color(255, 255, 255));
		
		itemLinkTxt = new JTextField();
		itemLinkTxt.setBounds(29, 143, 270, 26);
		itemLinkTxt.setColumns(10);
		
		itemPriceTxt = new JTextField();
		itemPriceTxt.setBounds(98, 202, 130, 26);
		itemPriceTxt.setColumns(10);
		
		JRadioButton dollarRadioButton = new JRadioButton("DOLLAR");
		dollarRadioButton.setBounds(116, 240, 83, 23);
		dollarRadioButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		JRadioButton euroRadioButton = new JRadioButton("EURO");
		euroRadioButton.setBounds(29, 240, 69, 23);
		euroRadioButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		JRadioButton kunaRadioButton = new JRadioButton("HR KN");
		kunaRadioButton.setBounds(217, 240, 82, 23);
		kunaRadioButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		euroRadioButton.setForeground(Color.WHITE);
		euroRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (euroRadioButton.isSelected()) {
					dollarRadioButton.setSelected(false);
					kunaRadioButton.setSelected(false);
					newItemCurrency = "€";
				}
			}
		});
		
		dollarRadioButton.setForeground(Color.WHITE);
		dollarRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dollarRadioButton.isSelected()) {
					euroRadioButton.setSelected(false);
					kunaRadioButton.setSelected(false);
					newItemCurrency = "$";
				}
			}
		});
		
		kunaRadioButton.setForeground(Color.WHITE);
		kunaRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kunaRadioButton.isSelected()) {
					euroRadioButton.setSelected(false);
					dollarRadioButton.setSelected(false);
					newItemCurrency = "Kn";
				}
			}
		});
		
		JButton addItemButton = new JButton("Add Item");
		addItemButton.setBounds(112, 275, 101, 29);
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WishlistMethods.addNewItem();		
			}
		});
		
		add(mainSection);
		mainSection.setLayout(null);
		mainSection.add(panel);
		panel.setLayout(null);
		panel.add(addItemButton);
		panel.add(itemLinkLabel);
		panel.add(itemPriceTxt);
		panel.add(itemPriceLabel);
		panel.add(yourWishlistLabel);
		panel.add(itemLinkTxt);
		panel.add(itemNameTxt);
		panel.add(euroRadioButton);
		panel.add(dollarRadioButton);
		panel.add(kunaRadioButton);
		panel.add(itemNameLabel);

	}

}
