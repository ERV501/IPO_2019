package presentation;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class pnlGuide extends JPanel {
	protected JTextField txtNombre;
	protected JTextField txtApellidos;
	protected JTextField txtEmail;
	protected JFormattedTextField txtDNI;
	protected JFormattedTextField txtTlf;
	protected JSpinner edad;
	protected JRadioButton rdbtnVarn;
	protected JRadioButton rdbtnHembra;
	protected JComboBox civil;
	protected JComboBox procedencia;
	protected JButton btnAceptar;

	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public pnlGuide() {

		
		setPreferredSize(new Dimension(Main.getTamano(500), Main.getTamano(500)));
		
		JPanel pnlForm = new JPanel();
		pnlForm.setPreferredSize(new Dimension(Main.getTamano(500), Main.getTamano(500)));
		add(pnlForm);
		GridBagLayout gbl_pnlForm = new GridBagLayout();
		gbl_pnlForm.columnWidths = new int[]{Main.getTamano(98), Main.getTamano(46), Main.getTamano(83), Main.getTamano(69), Main.getTamano(43),Main.getTamano(25), Main.getTamano(25), 0};
		gbl_pnlForm.rowHeights = new int[]{Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), Main.getTamano(30), 0};
		gbl_pnlForm.columnWeights = new double[]{0.0, 0.0, Main.getTamano(1), Main.getTamano(1), 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlForm.setLayout(gbl_pnlForm);
		
		JLabel lblId = new JLabel(Messages.getString("pnlGuide.lblId.text")); //$NON-NLS-1$
		lblId.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 1;
		pnlForm.add(lblId, gbc_lblId);
		
		
		//JFormattedTextField formattedTextFieldId = new JFormattedTextField();
		MaskFormatter formatoId;
		try {
		formatoId = new MaskFormatter("########'-U");
		formatoId.setPlaceholderCharacter('X');
		txtDNI = new JFormattedTextField(formatoId);
		txtDNI.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_formattedTextFieldId = new GridBagConstraints();
		gbc_formattedTextFieldId.gridwidth = 2;
		gbc_formattedTextFieldId.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_formattedTextFieldId.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldId.gridx = 2;
		gbc_formattedTextFieldId.gridy = 1;
		pnlForm.add(txtDNI, gbc_formattedTextFieldId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		JLabel lblNombre = new JLabel(Messages.getString("pnlGuide.lblNombre.text")); //$NON-NLS-1$
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		pnlForm.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		pnlForm.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApeliidos = new JLabel(Messages.getString("pnlGuide.lblApeliidos.text")); //$NON-NLS-1$
		lblApeliidos.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblApeliidos = new GridBagConstraints();
		gbc_lblApeliidos.anchor = GridBagConstraints.EAST;
		gbc_lblApeliidos.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblApeliidos.gridx = 1;
		gbc_lblApeliidos.gridy = 3;
		pnlForm.add(lblApeliidos, gbc_lblApeliidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 3;
		gbc_txtApellidos.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 2;
		gbc_txtApellidos.gridy = 3;
		pnlForm.add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblEmail = new JLabel(Messages.getString("pnlGuide.lblEmail.text")); //$NON-NLS-1$
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		pnlForm.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 3;
		gbc_txtEmail.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 4;
		pnlForm.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTlf = new JLabel(Messages.getString("pnlGuide.lblTlf.text")); //$NON-NLS-1$
		lblTlf.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblTlf = new GridBagConstraints();
		gbc_lblTlf.anchor = GridBagConstraints.EAST;
		gbc_lblTlf.insets = new Insets(0, 0, 5, 5);
		gbc_lblTlf.gridx = 1;
		gbc_lblTlf.gridy = 5;
		pnlForm.add(lblTlf, gbc_lblTlf);
		
		MaskFormatter formatoTlf;
		try {
		formatoTlf = new MaskFormatter("#########");
		formatoTlf.setPlaceholderCharacter('X');
		txtTlf = new JFormattedTextField(formatoTlf);
		txtTlf.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.gridwidth = 2;
		gbc_formattedTextField.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 2;
		gbc_formattedTextField.gridy = 5;
		pnlForm.add(txtTlf, gbc_formattedTextField);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel lblEdad = new JLabel(Messages.getString("pnlGuide.lblEdad.text")); //$NON-NLS-1$
		lblEdad.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblEdad.gridx = 1;
		gbc_lblEdad.gridy = 7;
		pnlForm.add(lblEdad, gbc_lblEdad);
		
		edad = new JSpinner();
		edad.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		edad.setModel(new SpinnerNumberModel(18, 18, 99, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 7;
		pnlForm.add(edad, gbc_spinner);
		
		JLabel lblGnero = new JLabel(Messages.getString("pnlGuide.lblGnero.text")); //$NON-NLS-1$
		lblGnero.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblGnero.gridx = 1;
		gbc_lblGnero.gridy = 8;
		pnlForm.add(lblGnero, gbc_lblGnero);
		
		rdbtnVarn = new JRadioButton(Messages.getString("pnlGuide.rdbtnVarn.text")); //$NON-NLS-1$
		rdbtnVarn.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_rdbtnVarn = new GridBagConstraints();
		gbc_rdbtnVarn.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_rdbtnVarn.gridx = 2;
		gbc_rdbtnVarn.gridy = 8;
		pnlForm.add(rdbtnVarn, gbc_rdbtnVarn);
		
		ButtonGroup bgroup_gender = new ButtonGroup();
		bgroup_gender.add(rdbtnVarn);
		
		rdbtnHembra = new JRadioButton(Messages.getString("pnlGuide.rdbtnHembra.text")); //$NON-NLS-1$
		rdbtnHembra.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_rdbtnHembra = new GridBagConstraints();
		gbc_rdbtnHembra.insets = new Insets(0, 0,Main.getTamano(5),Main.getTamano(5));
		gbc_rdbtnHembra.gridx = 3;
		gbc_rdbtnHembra.gridy = 8;
		pnlForm.add(rdbtnHembra, gbc_rdbtnHembra);
		bgroup_gender.add(rdbtnHembra);
		
		JLabel lblEstadoCivil = new JLabel(Messages.getString("pnlGuide.lblEstadoCivil.text")); //$NON-NLS-1$
		lblEstadoCivil.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblEstadoCivil = new GridBagConstraints();
		gbc_lblEstadoCivil.anchor = GridBagConstraints.EAST;
		gbc_lblEstadoCivil.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblEstadoCivil.gridx = 1;
		gbc_lblEstadoCivil.gridy = 10;
		pnlForm.add(lblEstadoCivil, gbc_lblEstadoCivil);
		
		civil = new JComboBox();
		civil.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		civil.setModel(new DefaultComboBoxModel<>(Guide.Estado.values()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 10;
		pnlForm.add(civil, gbc_comboBox);
		
		JLabel lblProcedencia = new JLabel(Messages.getString("pnlGuide.lblProcedencia.text")); //$NON-NLS-1$
		lblProcedencia.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblProcedencia = new GridBagConstraints();
		gbc_lblProcedencia.anchor = GridBagConstraints.EAST;
		gbc_lblProcedencia.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblProcedencia.gridx = 1;
		gbc_lblProcedencia.gridy = 11;
		pnlForm.add(lblProcedencia, gbc_lblProcedencia);
		
		procedencia = new JComboBox();
		procedencia.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		procedencia.setModel(new DefaultComboBoxModel<>(Guide.Pais.values()));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 11;
		pnlForm.add(procedencia, gbc_comboBox_1);
		
		btnAceptar = new JButton(Messages.getString("pnlGuide.btnAceptar.text")); //$NON-NLS-1$
		btnAceptar.setToolTipText(Messages.getString("pnlGuide.btnAceptar.toolTipText")); //$NON-NLS-1$
		btnAceptar.setIcon(new ImageIcon(pnlGuide.class.getResource("/presentation/check-mark_16x16.png")));
		btnAceptar.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(13)));
		btnAceptar.setBackground(new Color(144, 238, 144));
		btnAceptar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.gridwidth = 2;
		gbc_btnAceptar.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_btnAceptar.gridx = 4;
		gbc_btnAceptar.gridy = 14;
		pnlForm.add(btnAceptar, gbc_btnAceptar);

	}

}
