package presentation;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Container;

import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import presentation.Guide.Estado;
import presentation.Guide.Pais;
import presentation.pnlGuideManagement.TxtSearchMouseListener;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class pnlGuideManagement extends JPanel {

	protected JSplitPane splitPane;
	private JPanel pnlSearch;
	private JToolBar toolBar;
	private JTextField txtSearch;
	private JLabel lblSearch;
	private JPanel panel;
	protected JButton btnBlue;
	protected JButton btnRed;
	protected static JList list;
	protected static DefaultListModel modeloLista;
	private JScrollPane scrollPane;
	private pnlGuide pnlForm;

	/**
	 * Create the panel.
	 */
	public pnlGuideManagement() {

		setSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));

		splitPane = new JSplitPane();
		splitPane.setSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));
		add(splitPane);

		pnlSearch = new JPanel();
		pnlSearch.setSize(new Dimension(Main.getTamano(300), Main.getTamano(500)));
		pnlSearch.setLayout(new BorderLayout(0, 0));
		splitPane.setLeftComponent(pnlSearch);

		panel = new JPanel();
		pnlSearch.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		toolBar = new JToolBar();
		toolBar.setPreferredSize(new Dimension(Main.getTamano(300), Main.getTamano(24)));
		toolBar.setFloatable(false);
		panel.add(toolBar, BorderLayout.NORTH);

		lblSearch = new JLabel(""); //$NON-NLS-1$
		lblSearch.setIcon(new ImageIcon(Main.class.getResource("/presentation/loupe.png"))); //$NON-NLS-1$
		toolBar.add(lblSearch);

		txtSearch = new RoundJTextField(32);
		txtSearch.setToolTipText(Messages.getString("pnlGuideManagement.txtSearch.toolTipText")); //$NON-NLS-1$
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 8) {
					txtSearch.setText(""); //$NON-NLS-1$
					list.setModel(modeloLista);
				} else {
					searchFilter(txtSearch.getText());
				}
			}
		});
		txtSearch.addMouseListener(new TxtSearchMouseListener());
		toolBar.add(txtSearch);
		txtSearch.setColumns(10);

		btnBlue = new JButton(Messages.getString("pnlGuideManagement.btnBlue.text")); //$NON-NLS-1$
		btnBlue.setToolTipText(Messages.getString("pnlGuideManagement.btnBlue.toolTipText")); //$NON-NLS-1$
		btnBlue.setIcon(new ImageIcon(pnlGuideManagement.class.getResource("/presentation/add.png"))); //$NON-NLS-1$
		btnBlue.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(10))); //$NON-NLS-1$
		btnBlue.setBackground(Color.CYAN);
		btnBlue.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBlue.setPreferredSize(new Dimension(Main.getTamano(75), Main.getTamano(20)));
		toolBar.add(btnBlue);

		btnRed = new JButton(Messages.getString("pnlGuideManagement.btnRed.text")); //$NON-NLS-1$
		btnRed.setToolTipText(Messages.getString("pnlGuideManagement.btnRed.toolTipText")); //$NON-NLS-1$
		btnRed.setIcon(new ImageIcon(pnlGuideManagement.class.getResource("/presentation/delete-button.png"))); //$NON-NLS-1$
		btnRed.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(10))); //$NON-NLS-1$
		btnRed.setForeground(Color.WHITE);
		btnRed.setBackground(Color.RED);
		btnRed.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRed.setPreferredSize(new Dimension(Main.getTamano(100), Main.getTamano(20)));
		toolBar.add(btnRed);

		scrollPane = new JScrollPane((Component) null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(Main.getTamano(300), Main.getTamano(460)));
		scrollPane.setMinimumSize(new Dimension(Main.getTamano(300), Main.getTamano(460)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setAutoscrolls(true);
		scrollPane.setAlignmentY(0.0f);
		scrollPane.setAlignmentX(0.0f);
		panel.add(scrollPane, BorderLayout.SOUTH);

		list = new JList();
		list.setAlignmentX(Component.LEFT_ALIGNMENT);
		list.setAlignmentY(Component.TOP_ALIGNMENT);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "" }; //$NON-NLS-1$

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);

		modeloLista = new DefaultListModel();
		list.setModel(modeloLista);

		list.setCellRenderer(new NuestroCellRenderer());

		pnlForm = new pnlGuide();
		pnlForm.txtTlf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlForm.txtTlf.setText(""); //$NON-NLS-1$
			}
		});
		pnlForm.txtDNI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlForm.txtDNI.setText(""); //$NON-NLS-1$
			}
		});
		splitPane.setRightComponent(pnlForm);

		initialize();

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (list.getSelectedIndex() != -1) {
					Guide g = (Guide) modeloLista.getElementAt(list.getSelectedIndex());
					((pnlGuide) pnlForm).txtNombre.setText(g.getNombre());
					((pnlGuide) pnlForm).txtApellidos.setText(g.getApellidos());
					((pnlGuide) pnlForm).txtEmail.setText(g.getEmail());
					((pnlGuide) pnlForm).txtDNI.setText(g.getDNI());
					((pnlGuide) pnlForm).txtTlf.setText(g.getTlf());
					((pnlGuide) pnlForm).edad.setValue(g.getEdad());
					if (g.genero.equals(Guide.Genero.Varon)) {
						((pnlGuide) pnlForm).rdbtnVarn.setSelected(true);
						((pnlGuide) pnlForm).rdbtnHembra.setSelected(false);
					} else {
						((pnlGuide) pnlForm).rdbtnVarn.setSelected(false);
						((pnlGuide) pnlForm).rdbtnHembra.setSelected(true);
					}
					((pnlGuide) pnlForm).civil.setSelectedItem(g.civil);
					((pnlGuide) pnlForm).procedencia.setSelectedItem(g.procedencia);
					list.ensureIndexIsVisible(list.getSelectedIndex());
				}
			}
		});

		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() != -1) {
					if (modeloLista.getSize() != 0) {
						int indice = list.getSelectedIndex();
						modeloLista.remove(indice);
						if (modeloLista.getSize() == 0 || indice > modeloLista.getSize() - 1)
							indice--;
						list.setSelectedIndex(indice);
						list.ensureIndexIsVisible(indice);
					}
				}
			}
		});

		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int indice = modeloLista.getSize();

				if (indice > 0) {
					Guide g = (Guide) modeloLista.getElementAt(indice - 1);
					if (g.getValid()) {
						g = new Guide("", "", "", "", 18, "", Guide.Genero.Varon, Guide.Estado.Otro, Guide.Pais.Espana); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
						((DefaultListModel) modeloLista).addElement(g);
						list.setSelectedIndex(indice);
						list.ensureIndexIsVisible(indice);
					} else {
						showError(Messages.getString("pnlGuideManagement.15")); //$NON-NLS-1$
					}
				} else {
					Guide g = new Guide("", "", "", "", 18, "", Guide.Genero.Varon, Guide.Estado.Otro, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
							Guide.Pais.Espana);
					((DefaultListModel) modeloLista).addElement(g);
					list.setSelectedIndex(indice);
					list.ensureIndexIsVisible(indice);
				}

			}
		});

		((pnlGuide) pnlForm).btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Guide g = (Guide) modeloLista.getElementAt(list.getSelectedIndex());

					g.setValid(true);

					if (((pnlGuide) pnlForm).txtNombre.getText() == "") { //$NON-NLS-1$
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGuideManagement.22")); //$NON-NLS-1$
					} else {
						g.setNombre(((pnlGuide) pnlForm).txtNombre.getText());
					}

					if (((pnlGuide) pnlForm).txtApellidos.getText() == "") { //$NON-NLS-1$
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGuideManagement.24")); //$NON-NLS-1$
					} else {
						g.setApellidos(((pnlGuide) pnlForm).txtApellidos.getText());
					}

					if (((pnlGuide) pnlForm).txtEmail.getText() == "" //$NON-NLS-1$
							|| !((pnlGuide) pnlForm).txtEmail.getText().contains("@")) { //$NON-NLS-1$
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGuideManagement.27")); //$NON-NLS-1$
					} else {
						g.setEmail(((pnlGuide) pnlForm).txtEmail.getText());
					}

					if (((pnlGuide) pnlForm).txtDNI.getText() == "") { //$NON-NLS-1$
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGuideManagement.29")); //$NON-NLS-1$
					} else {
						g.setDNi(((pnlGuide) pnlForm).txtDNI.getText());
					}

					if (((pnlGuide) pnlForm).txtTlf.getText() == "") { //$NON-NLS-1$
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGuideManagement.31")); //$NON-NLS-1$
					} else {
						g.setTlf(((pnlGuide) pnlForm).txtTlf.getText());
					}

					g.setEdad(((Integer) (((pnlGuide) pnlForm).edad.getValue())));

					if (((pnlGuide) pnlForm).rdbtnVarn.isSelected()) {
						g.setGenero(Guide.Genero.Varon);
					} else {
						g.setGenero(Guide.Genero.Hembra);
					}

					g.setCivil((Estado) ((pnlGuide) pnlForm).civil.getSelectedItem());
					g.setProcedencia((Pais) ((pnlGuide) pnlForm).procedencia.getSelectedItem());

					list.ensureIndexIsVisible(list.getSelectedIndex());
					list.repaint();

				} catch (Exception ex) {
					showError(ex.getMessage());
				}

			}
		});

	}

	private void initialize() {

		Guide g = new Guide("00000000A", "Pedro", "Perez", "pedro@gmail.com", 28, "611111111", Guide.Genero.Varon,
				Guide.Estado.Casado, Guide.Pais.Espana);
		g.setValid(true);
		modeloLista.addElement(g);
		g = new Guide("00000001J", "Alfredo", "Suarez", "alfred89@gmail.com", 58, "622111222", Guide.Genero.Varon,
				Guide.Estado.Divorciado, Guide.Pais.Espana);
		g.setValid(true);
		modeloLista.addElement(g);
		g = new Guide("00000000A", "Julia", "Rulanda", "Juliia@gmail.com", 34, "633111131", Guide.Genero.Hembra,
				Guide.Estado.Soltero, Guide.Pais.Italia);
		g.setValid(true);
		modeloLista.addElement(g);

		list.setSelectedIndex(0);

		g = (Guide) modeloLista.getElementAt(list.getSelectedIndex());
		((pnlGuide) pnlForm).txtNombre.setText(g.getNombre());
		((pnlGuide) pnlForm).txtApellidos.setText(g.getApellidos());
		((pnlGuide) pnlForm).txtEmail.setText(g.getEmail());
		((pnlGuide) pnlForm).txtDNI.setText(g.getDNI());
		((pnlGuide) pnlForm).txtTlf.setText(g.getTlf());
		((pnlGuide) pnlForm).edad.setValue(g.getEdad());
		if (g.genero.equals(Guide.Genero.Varon)) {
			((pnlGuide) pnlForm).rdbtnVarn.setSelected(true);
			((pnlGuide) pnlForm).rdbtnHembra.setSelected(false);
		} else {
			((pnlGuide) pnlForm).rdbtnVarn.setSelected(false);
			((pnlGuide) pnlForm).rdbtnHembra.setSelected(true);
		}
		((pnlGuide) pnlForm).civil.setSelectedItem(g.civil);
		((pnlGuide) pnlForm).procedencia.setSelectedItem(g.procedencia);
		list.ensureIndexIsVisible(list.getSelectedIndex());

		list.ensureIndexIsVisible(list.getSelectedIndex());

	}
	
	public static DefaultListModel getModeloLista() {
		return modeloLista;
	}

	private void searchFilter(String searchTerm) {

		DefaultListModel filteredItems = new DefaultListModel();

		for (int i = 0; i < list.getModel().getSize(); i++) {

			Guide g = (Guide) list.getModel().getElementAt(i);
			String name = g.getNombre().toLowerCase();
			if (name.startsWith(searchTerm.toLowerCase()))
				filteredItems.addElement(g);

		}
		list.setModel(filteredItems);
	}

	public class TxtSearchMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			txtSearch.setText(""); //$NON-NLS-1$
		}
	}

	public static void showError(String errorMessage) {
		showError(errorMessage, "Error!"); //$NON-NLS-1$
	}

	public static void showError(Exception exceptionError) {
		String errorMessage = Messages.getString("pnlGuideManagement.43") + exceptionError.getMessage() //$NON-NLS-1$
				+ "\nStackTrace: " //$NON-NLS-1$
				+ Arrays.toString(exceptionError.getStackTrace());
		String title = exceptionError.getClass().getName();
		showError(errorMessage, title);
	}

	public static void showError(String errorMessage, String title) {
		JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);
	}

}
