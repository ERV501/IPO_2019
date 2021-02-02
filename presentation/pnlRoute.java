package presentation;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class pnlRoute extends JPanel {
	protected JTextField txtNombre;
	protected JTextField txtLongitud;
	protected JFormattedTextField txtID;
	protected JComboBox salida;
	protected JComboBox llegada;
	protected JButton btnAceptar;
	protected JButton btnDibujarRuta;
	protected static JLabel lblMapa;
	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public pnlRoute() {
		setPreferredSize(new Dimension(Main.getTamano(500), Main.getTamano(500)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{Main.getTamano(25), Main.getTamano(25), Main.getTamano(20), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Main.getTamano(20), Main.getTamano(20), 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Main.getTamano(33), Main.getTamano(38), Main.getTamano(37), 0, Main.getTamano(39), Main.getTamano(25), 0, Main.getTamano(30), 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Main.getTamano(1), Main.getTamano(1), 0.0, 0.0, Main.getTamano(1), Main.getTamano(1), 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblMapa = new JLabel("");
		lblMapa.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblMapa.setPreferredSize(new Dimension(Main.getTamano(400), Main.getTamano(250)));
		lblMapa.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblMapa.setIcon(new ImageIcon(pnlRoute.class.getResource("/presentation/Mapa_de_carreteras_de_la_Provincia_de_Ciudad_Real.png")));
		lblMapa.setToolTipText(Messages.getString("pnlRoute.lblMapa.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMapa = new GridBagConstraints();
		gbc_lblMapa.gridwidth = 16;
		gbc_lblMapa.gridheight = 7;
		gbc_lblMapa.insets = new Insets(0, 0, 5, 5);
		gbc_lblMapa.gridx = 1;
		gbc_lblMapa.gridy = 3;
		add(lblMapa, gbc_lblMapa);
		
		JLabel lblId = new JLabel(Messages.getString("pnlRoute.lblId.text")); //$NON-NLS-1$
		lblId.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.gridwidth = 2;
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblId.gridx = 3;
		gbc_lblId.gridy = 10;
		add(lblId, gbc_lblId);
		
		//JFormattedTextField formattedTextField = new JFormattedTextField();
		MaskFormatter formatoId;
try {
		formatoId = new MaskFormatter("###");
		formatoId.setPlaceholderCharacter('X');
		txtID = new JFormattedTextField(formatoId);
		txtID.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.gridwidth = 3;
		gbc_formattedTextField.insets = new Insets(0, 0,Main.getTamano(5), Main.getTamano(5));
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 5;
		gbc_formattedTextField.gridy = 10;
		add(txtID, gbc_formattedTextField);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNombreRuta = new JLabel(Messages.getString("pnlRoute.lblNombreRuta.text")); //$NON-NLS-1$
		lblNombreRuta.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblNombreRuta = new GridBagConstraints();
		gbc_lblNombreRuta.gridwidth = 3;
		gbc_lblNombreRuta.anchor = GridBagConstraints.EAST;
		gbc_lblNombreRuta.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblNombreRuta.gridx = 2;
		gbc_lblNombreRuta.gridy = 11;
		add(lblNombreRuta, gbc_lblNombreRuta);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 8;
		gbc_textField.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 11;
		add(txtNombre, gbc_textField);
		txtNombre.setColumns(10);
		
		JLabel lblLongitud = new JLabel(Messages.getString("pnlRoute.lblLongitud.text")); //$NON-NLS-1$
		lblLongitud.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblLongitud = new GridBagConstraints();
		gbc_lblLongitud.anchor = GridBagConstraints.EAST;
		gbc_lblLongitud.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblLongitud.gridx = 4;
		gbc_lblLongitud.gridy = 12;
		add(lblLongitud, gbc_lblLongitud);
		
		txtLongitud = new JTextField();
		txtLongitud.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 12;
		add(txtLongitud, gbc_textField_1);
		txtLongitud.setColumns(10);
		
		JLabel lblKm = new JLabel(Messages.getString("pnlRoute.lblKm.text")); //$NON-NLS-1$
		lblKm.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblKm = new GridBagConstraints();
		gbc_lblKm.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblKm.gridx = 8;
		gbc_lblKm.gridy = 12;
		add(lblKm, gbc_lblKm);
		
		JLabel lblSalida = new JLabel(Messages.getString("pnlRoute.lblSalida.text")); //$NON-NLS-1$
		lblSalida.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblSalida = new GridBagConstraints();
		gbc_lblSalida.anchor = GridBagConstraints.EAST;
		gbc_lblSalida.insets = new Insets(0, 0,Main.getTamano(5), Main.getTamano(5));
		gbc_lblSalida.gridx = 4;
		gbc_lblSalida.gridy = 13;
		add(lblSalida, gbc_lblSalida);
		
		llegada = new JComboBox();
		llegada.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		llegada.setModel(new DefaultComboBoxModel<>(Route.Ciudades.values()));

		gbc_comboBox_1.gridwidth = 9;
		gbc_comboBox_1.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 13;
		add(llegada, gbc_comboBox_1);
		
		JLabel lblLlegada = new JLabel(Messages.getString("pnlRoute.lblLlegada.text")); //$NON-NLS-1$
		lblLlegada.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblLlegada = new GridBagConstraints();
		gbc_lblLlegada.anchor = GridBagConstraints.EAST;
		gbc_lblLlegada.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblLlegada.gridx = 4;
		gbc_lblLlegada.gridy = 14;
		add(lblLlegada, gbc_lblLlegada);
		
		salida = new JComboBox();
		salida.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		salida.setModel(new DefaultComboBoxModel<>(Route.Ciudades.values()));
		gbc_comboBox.gridwidth = 9;
		gbc_comboBox.insets = new Insets(0, 0,Main.getTamano(5), Main.getTamano(5));
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 14;
		add(salida, gbc_comboBox);
		
		btnDibujarRuta = new JButton(Messages.getString("pnlRoute.btnDibujarRuta.text")); //$NON-NLS-1$
		btnDibujarRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDibujarRuta.setToolTipText(Messages.getString("pnlRoute.btnDibujarRuta.toolTipText")); //$NON-NLS-1$
		btnDibujarRuta.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDibujarRuta.setIcon(new ImageIcon(pnlRoute.class.getResource("/presentation/dibujar.png")));
		btnDibujarRuta.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(13)));
		GridBagConstraints gbc_btnDibujarRuta = new GridBagConstraints();
		gbc_btnDibujarRuta.insets = new Insets(0, 0,Main.getTamano(5), Main.getTamano(5));
		gbc_btnDibujarRuta.gridx = 4;
		gbc_btnDibujarRuta.gridy = 16;
		add(btnDibujarRuta, gbc_btnDibujarRuta);
		
		btnAceptar = new JButton(Messages.getString("pnlRoute.btnAceptar.text")); //$NON-NLS-1$
		btnAceptar.setToolTipText(Messages.getString("pnlRoute.btnAceptar.toolTipText")); //$NON-NLS-1$
		btnAceptar.setIcon(new ImageIcon(pnlRoute.class.getResource("/presentation/check-mark_16x16.png")));
		btnAceptar.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(13)));
		btnAceptar.setMinimumSize(new Dimension(Main.getTamano(75), Main.getTamano(23)));
		btnAceptar.setMaximumSize(new Dimension(Main.getTamano(75), Main.getTamano(23)));
		btnAceptar.setBackground(new Color(144, 238, 144));
		btnAceptar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificar.gridwidth = 4;
		gbc_btnModificar.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_btnModificar.gridx = 10;
		gbc_btnModificar.gridy = 16;
		add(btnAceptar, gbc_btnModificar);
		
	}

}
