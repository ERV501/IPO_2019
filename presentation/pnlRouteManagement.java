package presentation;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import java.awt.Component;
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

import presentation.Guide.Pais;
import presentation.Route.Ciudades;
import presentation.pnlGuideManagement.TxtSearchMouseListener;

import javax.swing.border.BevelBorder;
import java.awt.Font;

public class pnlRouteManagement extends JPanel {

	protected JSplitPane splitPane;
	private JPanel pnlSearch;
	private JToolBar toolBar;
	private JTextField txtSearch;
	private JLabel lblSearch;
	private JPanel panel;
	protected JButton btnBlue;
	protected JButton btnRed;
	static JList list;
	private JScrollPane scrollPane;
	protected static pnlRoute pnlForm;
	protected static DefaultListModel modeloLista;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public pnlRouteManagement() {

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

		txtSearch = new RoundJTextField(32);
		txtSearch.setToolTipText(Messages.getString("pnlRouteManagement.txtSearch.toolTipText")); //$NON-NLS-1$
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

		lblSearch = new JLabel(""); //$NON-NLS-1$
		lblSearch.setToolTipText(Messages.getString("pnlRouteManagement.lblSearch.toolTipText")); //$NON-NLS-1$
		lblSearch.setIcon(new ImageIcon(Main.class.getResource("/presentation/loupe.png"))); //$NON-NLS-1$
		toolBar.add(lblSearch);
		toolBar.add(txtSearch);
		txtSearch.setColumns(10);

		btnBlue = new JButton(Messages.getString("pnlRouteManagement.btnBlue.text")); //$NON-NLS-1$
		btnBlue.setToolTipText(Messages.getString("pnlRouteManagement.btnBlue.toolTipText")); //$NON-NLS-1$
		btnBlue.setIcon(new ImageIcon(pnlRouteManagement.class.getResource("/presentation/add.png"))); //$NON-NLS-1$
		btnBlue.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(10))); //$NON-NLS-1$
		btnBlue.setBackground(Color.CYAN);
		btnBlue.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBlue.setPreferredSize(new Dimension(Main.getTamano(75), Main.getTamano(20)));
		toolBar.add(btnBlue);

		btnRed = new JButton(Messages.getString("pnlRouteManagement.btnRed.text")); //$NON-NLS-1$
		btnRed.setToolTipText(Messages.getString("pnlRouteManagement.btnRed.toolTipText")); //$NON-NLS-1$
		btnRed.setIcon(new ImageIcon(pnlRouteManagement.class.getResource("/presentation/delete-button.png"))); //$NON-NLS-1$
		btnRed.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(13))); //$NON-NLS-1$
		btnRed.setForeground(Color.WHITE);
		btnRed.setBackground(Color.RED);
		btnRed.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRed.setPreferredSize(new Dimension(Main.getTamano(100), Main.getTamano(20)));
		toolBar.add(btnRed);

		scrollPane = new JScrollPane((Component) null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(new Dimension(Main.getTamano(300), Main.getTamano(460)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setAutoscrolls(true);
		scrollPane.setAlignmentY(0.0f);
		scrollPane.setAlignmentX(0.0f);
		panel.add(scrollPane, BorderLayout.SOUTH);

		pnlForm = new pnlRoute();
		pnlForm.setSize(new Dimension(Main.getTamano(500), 0));
		pnlForm.setLayout(new GridLayout(1, 0, 0, 0));

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

		pnlForm = new pnlRoute();
		pnlForm.txtID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlForm.txtID.setText(""); //$NON-NLS-1$
			}
		});
		splitPane.setRightComponent(pnlForm);

		initialize();

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (list.getSelectedIndex() != -1) {
					Route r = (Route) modeloLista.getElementAt(list.getSelectedIndex());
					((pnlRoute) pnlForm).txtNombre.setText(r.getNombre());
					((pnlRoute) pnlForm).txtLongitud.setText(Float.toString(r.getLongitud()));
					((pnlRoute) pnlForm).txtID.setText(Integer.toString(r.getID()));
					((pnlRoute) pnlForm).salida.setSelectedItem(r.salida);
					((pnlRoute) pnlForm).llegada.setSelectedItem(r.llegada);
					((pnlRoute) pnlForm).lblMapa.setIcon(r.getImage());
					
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
						pnlRouteContraction.listRoute.setModel(list.getModel());
						list.ensureIndexIsVisible(indice);
					}
				}
			}
		});

		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int indice = modeloLista.getSize();

				if (indice > 0) {
					Route r = (Route) modeloLista.getElementAt(indice - 1);
					if (r.getValid()) {
						r = new Route(1, "", (float) 0.0, Route.Ciudades.Capital, Route.Ciudades.Capital);
						modeloLista.addElement(r);
						list.setSelectedIndex(modeloLista.getSize() - 1);
						pnlRouteContraction.listRoute.setModel(list.getModel());
						list.ensureIndexIsVisible(indice);
					} else {
						showError(Messages.getString("pnlRouteManagement.0")); //$NON-NLS-1$
					}
				} else {
					Route r = new Route(1, "", (float) 0.0, Route.Ciudades.Capital, Route.Ciudades.Capital); //$NON-NLS-1$
					modeloLista.addElement(r);
					list.setSelectedIndex(modeloLista.getSize() - 1);
					pnlRouteContraction.listRoute.setModel(list.getModel());
					list.ensureIndexIsVisible(indice);
				}
			}
		});

		((pnlRoute) pnlForm).btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Route r = (Route) modeloLista.getElementAt(list.getSelectedIndex());

					r.setValid(true);

					if (((pnlRoute) pnlForm).txtNombre.getText() == "") { //$NON-NLS-1$
						r.setValid(false);
						throw new Exception(Messages.getString("pnlRouteManagement.13")); //$NON-NLS-1$
					} else {
						r.setNombre(((pnlRoute) pnlForm).txtNombre.getText());
					}
					
					if (((pnlRoute) pnlForm).txtLongitud.getText() == "" //$NON-NLS-1$
							|| Float.valueOf(((pnlRoute) pnlForm).txtLongitud.getText()) <= 0.0) {
						r.setValid(false);
						throw new Exception(Messages.getString("pnlRouteManagement.15")); //$NON-NLS-1$
					} else {
						r.setLongitud(Float.valueOf(((pnlRoute) pnlForm).txtLongitud.getText()));
					}

					if (((pnlRoute) pnlForm).txtID.getText() == "") { //$NON-NLS-1$
						r.setValid(false);
						throw new Exception(Messages.getString("pnlRouteManagement.17")); //$NON-NLS-1$
					} else {
						r.setID(Integer.valueOf(((pnlRoute) pnlForm).txtID.getText()));
					}
					
					r.setSalida( (Ciudades) ((pnlRoute) pnlForm).salida.getSelectedItem());
					r.setLlegada( (Ciudades) ((pnlRoute) pnlForm).llegada.getSelectedItem());

					pnlRouteContraction.listRoute.setModel(list.getModel());

					list.ensureIndexIsVisible(list.getSelectedIndex());
					list.repaint();

				} catch (Exception ex) {
					showError(ex.getMessage());
				}

			}
		});

		((pnlRoute) pnlForm).btnDibujarRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditorGrafico editor=new EditorGrafico();
				editor.frame.setVisible(true);
			}
		});
		
	}

	private void initialize() {
		
		Route r = new Route(111, "La Vieja", (float) 126.6 , Route.Ciudades.Alcazar, Route.Ciudades.Bolaños);
		r.setValid(true);
		modeloLista.addElement(r);
		r = new Route(111, "La Templaria", (float) 41.2 , Route.Ciudades.Daimiel, Route.Ciudades.Valdepeñas);
		r.setValid(true);
		modeloLista.addElement(r);
		r = new Route(111, "La Revoltosa", (float) 24.1 , Route.Ciudades.Capital, Route.Ciudades.Almagro);
		r.setValid(true);
		modeloLista.addElement(r);
		
		list.setSelectedIndex(0);
		pnlRouteContraction.listRoute.setModel(list.getModel());
		
		r = (Route) modeloLista.getElementAt(list.getSelectedIndex());
		((pnlRoute) pnlForm).txtNombre.setText(r.getNombre());
		((pnlRoute) pnlForm).txtLongitud.setText(Float.toString(r.getLongitud()));
		((pnlRoute) pnlForm).txtID.setText(Integer.toString(r.getID()));
		((pnlRoute) pnlForm).salida.setSelectedItem(r.salida);
		((pnlRoute) pnlForm).llegada.setSelectedItem(r.llegada);
		((pnlRoute) pnlForm).lblMapa.setIcon(r.getImage());
		
		list.ensureIndexIsVisible(list.getSelectedIndex());
		
		list.ensureIndexIsVisible(list.getSelectedIndex());

	}
	
	public static DefaultListModel getModeloLista() {
		return modeloLista;
	}

	private void searchFilter(String searchTerm) {

		DefaultListModel filteredItems = new DefaultListModel();

		for (int i = 0; i < list.getModel().getSize(); i++) {

			Route g = (Route) list.getModel().getElementAt(i);
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
		String errorMessage = Messages.getString("pnlRouteManagement.27") + exceptionError.getMessage() + "\nStackTrace: " //$NON-NLS-1$ //$NON-NLS-2$
				+ Arrays.toString(exceptionError.getStackTrace());
		String title = exceptionError.getClass().getName();
		showError(errorMessage, title);
	}

	public static void showError(String errorMessage, String title) {
		JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);
	}

}
