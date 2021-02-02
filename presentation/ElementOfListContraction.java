package presentation;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ElementOfListContraction extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JLabel lblGroup,lblDate;
	protected JLabel lblRoute;
	
	public ElementOfListContraction() {
		setBounds(new Rectangle(0, 0, Main.getTamano(280), Main.getTamano(100)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{93, 93, 93, 0};
		gridBagLayout.rowHeights = new int[]{56, 42, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblRoute = new JLabel("Route");
		GridBagConstraints gbc_lblRoute = new GridBagConstraints();
		gbc_lblRoute.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblRoute.gridx = 0;
		gbc_lblRoute.gridy = 0;
		add(lblRoute, gbc_lblRoute);
		
		lblGroup = new JLabel("Group");
		GridBagConstraints gbc_lblGroup = new GridBagConstraints();
		gbc_lblGroup.insets = new Insets(0, 0,Main.getTamano(5), Main.getTamano(0));
		gbc_lblGroup.gridx = 2;
		gbc_lblGroup.gridy = 0;
		add(lblGroup, gbc_lblGroup);
		
		lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.fill = GridBagConstraints.VERTICAL;
		gbc_lblDate.gridwidth = 3;
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 1;
		add(lblDate, gbc_lblDate);

	}

}
