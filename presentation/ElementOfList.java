package presentation;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class ElementOfList extends JPanel {
	protected JLabel lblTitle;
	protected JLabel lblInfo;
	private JLabel label;

	public ElementOfList() {
		setBounds(new Rectangle(0, 0, Main.getTamano(280), Main.getTamano(100)));
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(18)));
		add(lblTitle);
		
		//label = new JLabel("");
		//add(label);
		
		lblInfo = new JLabel("Info");
		lblInfo.setFont(new Font("Verdana", Font.ITALIC, Main.getTamano(10)));
		add(lblInfo);

	}
	
}