package presentation;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.ImageIcon;

public class pnlGroup extends JPanel {
	protected JTextField txtNombre;
	protected JTextField txtApellidos;
	protected JFormattedTextField txtGroupID;
	protected JSpinner Nmiembros;
	protected JFormattedTextField txtEdad;
	protected JFormattedTextField txtDNI;
	protected JButton btnAceptar;
	

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public pnlGroup() {
		setPreferredSize(new Dimension(Main.getTamano(500), Main.getTamano(500)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{25, 25, 25, 36, 65, 30, 20, 50, 50, 0, 25, 25, 25, 0};
		gridBagLayout.rowHeights = new int[]{25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblId_1 = new JLabel(Messages.getString("pnlGroup.lblId_1.text")); //$NON-NLS-1$
		lblId_1.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblId_1 = new GridBagConstraints();
		gbc_lblId_1.anchor = GridBagConstraints.EAST;
		gbc_lblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblId_1.gridx = 4;
		gbc_lblId_1.gridy = 3;
		add(lblId_1, gbc_lblId_1);
		
		MaskFormatter formatoId;
		try {
		formatoId = new MaskFormatter("###");
		formatoId.setPlaceholderCharacter('X');
		txtGroupID = new JFormattedTextField(formatoId);
		txtGroupID.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.gridwidth = 2;
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 5;
		gbc_formattedTextField.gridy = 3;
		add(txtGroupID, gbc_formattedTextField);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblMiembros = new JLabel(Messages.getString("pnlGroup.lblMiembros.text")); //$NON-NLS-1$
		lblMiembros.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblMiembros = new GridBagConstraints();
		gbc_lblMiembros.anchor = GridBagConstraints.EAST;
		gbc_lblMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiembros.gridx = 4;
		gbc_lblMiembros.gridy = 4;
		add(lblMiembros, gbc_lblMiembros);
		
		Nmiembros = new JSpinner();
		Nmiembros.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		Nmiembros.setModel(new SpinnerNumberModel(2, 2, 20, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.gridwidth = 2;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 5;
		gbc_spinner.gridy = 4;
		add(Nmiembros, gbc_spinner);
		
		JLabel lblMediaDeEdad = new JLabel(Messages.getString("pnlGroup.lblMediaDeEdad.text")); //$NON-NLS-1$
		lblMediaDeEdad.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_lblMediaDeEdad = new GridBagConstraints();
		gbc_lblMediaDeEdad.anchor = GridBagConstraints.EAST;
		gbc_lblMediaDeEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblMediaDeEdad.gridx = 4;
		gbc_lblMediaDeEdad.gridy = 5;
		add(lblMediaDeEdad, gbc_lblMediaDeEdad);
		
		MaskFormatter formatoEdad;
		//JFormattedTextField formattedTextFieldEdad = new JFormattedTextField();
		try {
			formatoEdad = new MaskFormatter("##");
			formatoEdad.setPlaceholderCharacter('X');
		txtEdad = new JFormattedTextField(formatoEdad);
		txtEdad.setFont(new Font("Verdana", Font.PLAIN, 13));
		//JFormattedTextField frmtdtxtfldId = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextFieldEdad = new GridBagConstraints();
		gbc_formattedTextFieldEdad.gridwidth = 2;
		gbc_formattedTextFieldEdad.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFieldEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldEdad.gridx = 5;
		gbc_formattedTextFieldEdad.gridy = 5;
		add(txtEdad, gbc_formattedTextFieldEdad);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblAos = new JLabel(Messages.getString("pnlGroup.lblAos.text")); //$NON-NLS-1$
		lblAos.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblAos = new GridBagConstraints();
		gbc_lblAos.insets = new Insets(0, 0, 5, 5);
		gbc_lblAos.gridx = 7;
		gbc_lblAos.gridy = 5;
		add(lblAos, gbc_lblAos);
		
		JLabel lblId = new JLabel(Messages.getString("pnlGroup.lblId.text")); //$NON-NLS-1$
		lblId.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 4;
		gbc_lblId.gridy = 7;
		add(lblId, gbc_lblId);
		

		MaskFormatter formato;
		try {
			
		formato = new MaskFormatter("########'-U");
		formato.setPlaceholderCharacter('X');
		txtDNI = new JFormattedTextField(formato);
		txtDNI.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		//JFormattedTextField frmtdtxtfldId = new JFormattedTextField();
		GridBagConstraints gbc_frmtdtxtfldId = new GridBagConstraints();
		gbc_frmtdtxtfldId.gridwidth = 3;
		gbc_frmtdtxtfldId.insets = new Insets(0, 0, 5, 5);
		gbc_frmtdtxtfldId.fill = GridBagConstraints.HORIZONTAL;
		gbc_frmtdtxtfldId.gridx = 5;
		gbc_frmtdtxtfldId.gridy = 7;
		add(txtDNI, gbc_frmtdtxtfldId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblNombreDelLder = new JLabel(Messages.getString("pnlGroup.lblNombreDelLder.text")); //$NON-NLS-1$
		lblNombreDelLder.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblNombreDelLder = new GridBagConstraints();
		gbc_lblNombreDelLder.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDelLder.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelLder.gridx = 4;
		gbc_lblNombreDelLder.gridy = 8;
		add(lblNombreDelLder, gbc_lblNombreDelLder);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 8;
		add(txtNombre, gbc_textField);
		txtNombre.setColumns(10);
		
		JLabel lblApellidosDelLder = new JLabel(Messages.getString("pnlGroup.lblApellidosDelLder.text")); //$NON-NLS-1$
		lblApellidosDelLder.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblApellidosDelLder = new GridBagConstraints();
		gbc_lblApellidosDelLder.anchor = GridBagConstraints.EAST;
		gbc_lblApellidosDelLder.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidosDelLder.gridx = 4;
		gbc_lblApellidosDelLder.gridy = 9;
		add(lblApellidosDelLder, gbc_lblApellidosDelLder);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 9;
		add(txtApellidos, gbc_textField_1);
		txtApellidos.setColumns(10);
		
		MaskFormatter formatoId_ruta;
		try {
			formatoId_ruta = new MaskFormatter("###");
			formatoId_ruta.setPlaceholderCharacter('X');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnAceptar = new JButton(Messages.getString("pnlGroup.btnAceptar.text")); //$NON-NLS-1$
		btnAceptar.setToolTipText(Messages.getString("pnlGroup.btnAceptar.toolTipText")); //$NON-NLS-1$
		btnAceptar.setIcon(new ImageIcon(pnlGroup.class.getResource("/presentation/check-mark_16x16.png")));
		btnAceptar.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(13)));
		btnAceptar.setMinimumSize(new Dimension(Main.getTamano(75), Main.getTamano(23)));
		btnAceptar.setMaximumSize(new Dimension(Main.getTamano(75), Main.getTamano(23)));
		btnAceptar.setPreferredSize(new Dimension(Main.getTamano(75), Main.getTamano(23)));
		btnAceptar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAceptar.setBackground(new Color(144, 238, 144));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridheight = 2;
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.gridwidth = 3;
		gbc_btnAceptar.insets = new Insets(0, 0,Main.getTamano(5), Main.getTamano(5));
		gbc_btnAceptar.gridx = 7;
		gbc_btnAceptar.gridy = 15;
		add(btnAceptar, gbc_btnAceptar);

	}

}
