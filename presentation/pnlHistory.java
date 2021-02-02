package presentation;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class pnlHistory extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textIdRuta;
	protected JTextField txtNombreruta;
	protected JTextField txtLongitud;
	protected JTextField txtIdGrupo;
	protected JTextField txtIdLider;
	protected JTextField txtFechacontratacion;
	protected JTextField txtSalida;
	protected JTextField txtLlegada;
	protected JTextField txtMiembros;

	/**
	 * Create the panel.
	 */
	public pnlHistory() {
		setPreferredSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, Main.getTamano(50), 0, 0, Main.getTamano(50), 0};
		gbl_panel.rowHeights = new int[]{0, 0, Main.getTamano(100), 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 20, 0, Main.getTamano(100), 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Main.getTamano(1), 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblIdRuta = new JLabel(Messages.getString("pnlHistory.lblIdRuta.text")); //$NON-NLS-1$
		lblIdRuta.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblIdRuta = new GridBagConstraints();
		gbc_lblIdRuta.anchor = GridBagConstraints.EAST;
		gbc_lblIdRuta.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblIdRuta.gridx = 2;
		gbc_lblIdRuta.gridy = 3;
		panel.add(lblIdRuta, gbc_lblIdRuta);
		
		textIdRuta = new JTextField();
		textIdRuta.setEditable(false);
		textIdRuta.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_textIdRuta = new GridBagConstraints();
		gbc_textIdRuta.insets = new Insets(0, 0,Main.getTamano(5), Main.getTamano(5));
		gbc_textIdRuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textIdRuta.gridx = 3;
		gbc_textIdRuta.gridy = 3;
		panel.add(textIdRuta, gbc_textIdRuta);
		textIdRuta.setColumns(10);
		
		JLabel lblNombreRuta = new JLabel(Messages.getString("pnlHistory.lblNombreRuta.text")); //$NON-NLS-1$
		lblNombreRuta.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblNombreRuta = new GridBagConstraints();
		gbc_lblNombreRuta.anchor = GridBagConstraints.EAST;
		gbc_lblNombreRuta.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblNombreRuta.gridx = 2;
		gbc_lblNombreRuta.gridy = 5;
		panel.add(lblNombreRuta, gbc_lblNombreRuta);
		
		txtNombreruta = new JTextField();
		txtNombreruta.setEditable(false);
		txtNombreruta.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_txtNombreruta = new GridBagConstraints();
		gbc_txtNombreruta.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtNombreruta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreruta.gridx = 3;
		gbc_txtNombreruta.gridy = 5;
		panel.add(txtNombreruta, gbc_txtNombreruta);
		txtNombreruta.setColumns(10);
		
		JLabel lblLongitud = new JLabel(Messages.getString("pnlHistory.lblLongitud.text")); //$NON-NLS-1$
		lblLongitud.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblLongitud = new GridBagConstraints();
		gbc_lblLongitud.anchor = GridBagConstraints.EAST;
		gbc_lblLongitud.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblLongitud.gridx = 2;
		gbc_lblLongitud.gridy = 6;
		panel.add(lblLongitud, gbc_lblLongitud);
		
		txtLongitud = new JTextField();
		txtLongitud.setToolTipText(Messages.getString("pnlHistory.txtLongitud.toolTipText")); //$NON-NLS-1$
		txtLongitud.setEditable(false);
		txtLongitud.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_txtLongitud = new GridBagConstraints();
		gbc_txtLongitud.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtLongitud.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLongitud.gridx = 3;
		gbc_txtLongitud.gridy = 6;
		panel.add(txtLongitud, gbc_txtLongitud);
		txtLongitud.setColumns(10);
		
		JLabel lblSalida = new JLabel(Messages.getString("pnlHistory.lblSalida.text")); //$NON-NLS-1$
		lblSalida.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblSalida = new GridBagConstraints();
		gbc_lblSalida.anchor = GridBagConstraints.EAST;
		gbc_lblSalida.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblSalida.gridx = 2;
		gbc_lblSalida.gridy = 7;
		panel.add(lblSalida, gbc_lblSalida);
		
		txtSalida = new JTextField();
		txtSalida.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		txtSalida.setEditable(false);
		txtSalida.setColumns(10);
		GridBagConstraints gbc_txtSalida = new GridBagConstraints();
		gbc_txtSalida.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSalida.gridx = 3;
		gbc_txtSalida.gridy = 7;
		panel.add(txtSalida, gbc_txtSalida);
		
		JLabel lblLlegada = new JLabel(Messages.getString("pnlHistory.lblLlegada.text")); //$NON-NLS-1$
		lblLlegada.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblLlegada = new GridBagConstraints();
		gbc_lblLlegada.insets = new Insets(0, 0, 5, 5);
		gbc_lblLlegada.anchor = GridBagConstraints.EAST;
		gbc_lblLlegada.gridx = 2;
		gbc_lblLlegada.gridy = 8;
		panel.add(lblLlegada, gbc_lblLlegada);
		
		txtLlegada = new JTextField();
		txtLlegada.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		txtLlegada.setEditable(false);
		txtLlegada.setColumns(10);
		GridBagConstraints gbc_txtLlegada = new GridBagConstraints();
		gbc_txtLlegada.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtLlegada.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLlegada.gridx = 3;
		gbc_txtLlegada.gridy = 8;
		panel.add(txtLlegada, gbc_txtLlegada);
		
		JLabel lblIdGrupo = new JLabel(Messages.getString("pnlHistory.lblIdGrupo.text")); //$NON-NLS-1$
		lblIdGrupo.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblIdGrupo = new GridBagConstraints();
		gbc_lblIdGrupo.anchor = GridBagConstraints.EAST;
		gbc_lblIdGrupo.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblIdGrupo.gridx = 2;
		gbc_lblIdGrupo.gridy = 10;
		panel.add(lblIdGrupo, gbc_lblIdGrupo);
		
		txtIdGrupo = new JTextField();
		txtIdGrupo.setEditable(false);
		txtIdGrupo.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_txtIdGrupo = new GridBagConstraints();
		gbc_txtIdGrupo.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtIdGrupo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdGrupo.gridx = 3;
		gbc_txtIdGrupo.gridy = 10;
		panel.add(txtIdGrupo, gbc_txtIdGrupo);
		txtIdGrupo.setColumns(10);
		
		JLabel lblMiembros = new JLabel(Messages.getString("pnlHistory.lblMiembros.text")); //$NON-NLS-1$
		lblMiembros.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblMiembros = new GridBagConstraints();
		gbc_lblMiembros.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblMiembros.anchor = GridBagConstraints.EAST;
		gbc_lblMiembros.gridx = 2;
		gbc_lblMiembros.gridy = 11;
		panel.add(lblMiembros, gbc_lblMiembros);
		
		txtMiembros = new JTextField();
		txtMiembros.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		txtMiembros.setEditable(false);
		txtMiembros.setColumns(10);
		GridBagConstraints gbc_txtMiembros = new GridBagConstraints();
		gbc_txtMiembros.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtMiembros.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMiembros.gridx = 3;
		gbc_txtMiembros.gridy = 11;
		panel.add(txtMiembros, gbc_txtMiembros);
		
		JLabel lblIdLder = new JLabel(Messages.getString("pnlHistory.lblIdLder.text")); //$NON-NLS-1$
		lblIdLder.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblIdLder = new GridBagConstraints();
		gbc_lblIdLder.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblIdLder.anchor = GridBagConstraints.EAST;
		gbc_lblIdLder.gridx = 2;
		gbc_lblIdLder.gridy = 12;
		panel.add(lblIdLder, gbc_lblIdLder);
		
		txtIdLider = new JTextField();
		txtIdLider.setEditable(false);
		txtIdLider.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_txtIdLider = new GridBagConstraints();
		gbc_txtIdLider.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtIdLider.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdLider.gridx = 3;
		gbc_txtIdLider.gridy = 12;
		panel.add(txtIdLider, gbc_txtIdLider);
		txtIdLider.setColumns(10);
		
		JLabel lblFechaContratacin = new JLabel(Messages.getString("pnlHistory.lblFechaContratacin.text")); //$NON-NLS-1$
		lblFechaContratacin.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_lblFechaContratacin = new GridBagConstraints();
		gbc_lblFechaContratacin.anchor = GridBagConstraints.EAST;
		gbc_lblFechaContratacin.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_lblFechaContratacin.gridx = 2;
		gbc_lblFechaContratacin.gridy = 14;
		panel.add(lblFechaContratacin, gbc_lblFechaContratacin);
		
		txtFechacontratacion = new JTextField();
		txtFechacontratacion.setEditable(false);
		txtFechacontratacion.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		GridBagConstraints gbc_txtFechacontratacion = new GridBagConstraints();
		gbc_txtFechacontratacion.insets = new Insets(0, 0, Main.getTamano(5), Main.getTamano(5));
		gbc_txtFechacontratacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechacontratacion.gridx = 3;
		gbc_txtFechacontratacion.gridy = 14;
		panel.add(txtFechacontratacion, gbc_txtFechacontratacion);
		txtFechacontratacion.setColumns(10);

	}

}
