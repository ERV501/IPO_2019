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

import presentation.pnlGuideManagement.TxtSearchMouseListener;

import javax.swing.border.BevelBorder;
import java.awt.Font;

public class pnlGroupManagement extends JPanel {

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
	protected pnlGroup pnlForm;
	protected static DefaultListModel modeloLista;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public pnlGroupManagement() {

		setSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));

		splitPane = new JSplitPane();
		splitPane.setSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));
		add(splitPane);

		pnlSearch = new JPanel();
		pnlSearch.setSize(new Dimension(Main.getTamano(300), 0));
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
		txtSearch.setToolTipText(Messages.getString("pnlGroupManagement.txtSearch.toolTipText")); //$NON-NLS-1$
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

		btnBlue = new JButton(Messages.getString("pnlGroupManagement.btnBlue.text")); //$NON-NLS-1$
		btnBlue.setToolTipText(Messages.getString("pnlGroupManagement.btnBlue.toolTipText")); //$NON-NLS-1$
		btnBlue.setIcon(new ImageIcon(pnlGroupManagement.class.getResource("/presentation/add.png"))); //$NON-NLS-1$
		btnBlue.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(10))); //$NON-NLS-1$
		btnBlue.setBackground(Color.CYAN);
		btnBlue.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBlue.setPreferredSize(new Dimension(Main.getTamano(75), Main.getTamano(20)));
		toolBar.add(btnBlue);

		btnRed = new JButton(Messages.getString("pnlGroupManagement.btnRed.text")); //$NON-NLS-1$
		btnRed.setToolTipText(Messages.getString("pnlGroupManagement.btnRed.toolTipText")); //$NON-NLS-1$
		btnRed.setIcon(new ImageIcon(pnlGroupManagement.class.getResource("/presentation/delete-button.png"))); //$NON-NLS-1$
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

		pnlForm = new pnlGroup();
		pnlForm.txtDNI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlForm.txtDNI.setText(""); //$NON-NLS-1$
			}
		});
		pnlForm.txtEdad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlForm.txtEdad.setText(""); //$NON-NLS-1$
			}
		});
		pnlForm.txtGroupID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlForm.txtGroupID.setText("");
			}
		});
		splitPane.setRightComponent(pnlForm);

		initialize();

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (list.getSelectedIndex() != -1) {
					Group g = (Group) modeloLista.getElementAt(list.getSelectedIndex());
					((pnlGroup) pnlForm).txtNombre.setText(g.getNombre());
					((pnlGroup) pnlForm).txtApellidos.setText(g.getApellidos());
					((pnlGroup) pnlForm).txtDNI.setText(g.getDNI());
					((pnlGroup) pnlForm).txtGroupID.setText(Integer.toString(g.getId()));
					((pnlGroup) pnlForm).Nmiembros.setValue(g.getNmiembros());
					((pnlGroup) pnlForm).txtEdad.setText(Integer.toString(g.getMediaEdad()));
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
						pnlRouteContraction.listGroup.setModel(list.getModel());
						list.ensureIndexIsVisible(indice);
					}
				}
			}
		});

		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int indice = modeloLista.getSize();

				if (indice > 0) {
					Group g = (Group) modeloLista.getElementAt(indice - 1);
					if (g.getValid()) {
						g = new Group(2, 1, 18, "", "", ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						modeloLista.addElement(g);
						list.setSelectedIndex(modeloLista.getSize() - 1);
						pnlRouteContraction.listGroup.setModel(list.getModel());
						list.ensureIndexIsVisible(indice);
					} else {
						showError(Messages.getString("pnlGroupManagement.14")); //$NON-NLS-1$
					}
				} else {
					Group g = new Group(2, 1, 18, "", "", ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					modeloLista.addElement(g);
					list.setSelectedIndex(modeloLista.getSize() - 1);
					pnlRouteContraction.listGroup.setModel(list.getModel());
					list.ensureIndexIsVisible(indice);
				}
			}
		});

		((pnlGroup) pnlForm).btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Group g = (Group) modeloLista.getElementAt(list.getSelectedIndex());

					g.setValid(true);

					if (((pnlGroup) pnlForm).txtNombre.getText() == "") { //$NON-NLS-1$
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGroupManagement.19")); //$NON-NLS-1$
					} else {
						g.setNombre(((pnlGroup) pnlForm).txtNombre.getText());
					}

					if (((pnlGroup) pnlForm).txtApellidos.getText() == "") { //$NON-NLS-1$
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGroupManagement.21")); //$NON-NLS-1$
					} else {
						g.setApellidos(((pnlGroup) pnlForm).txtApellidos.getText());
					}

					if ((((pnlGroup) pnlForm).txtGroupID.getText()) == "") { //$NON-NLS-1$
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGroupManagement.23")); //$NON-NLS-1$
					} else {
						g.setId((Integer.valueOf(((pnlGroup) pnlForm).txtGroupID.getText())));
					}

					if (((pnlGroup) pnlForm).txtDNI.getText() == "") { //$NON-NLS-1$
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGroupManagement.25")); //$NON-NLS-1$
					} else {
						g.setDNI(((pnlGroup) pnlForm).txtDNI.getText());
					}

					if (((pnlGroup) pnlForm).txtEdad.getText() == "" //$NON-NLS-1$
							|| Integer.valueOf(((pnlGroup) pnlForm).txtEdad.getText()) <= 0
							|| Integer.valueOf(((pnlGroup) pnlForm).txtEdad.getText()) >= 100) {
						g.setValid(false);
						throw new Exception(Messages.getString("pnlGroupManagement.27")); //$NON-NLS-1$
					} else {
						g.setMediaEdad(Integer.valueOf(((pnlGroup) pnlForm).txtEdad.getText()));
					}

					g.setNmiembros((Integer) ((pnlGroup) pnlForm).Nmiembros.getValue());

					pnlRouteContraction.listGroup.setModel(list.getModel());

					list.ensureIndexIsVisible(list.getSelectedIndex());
					list.repaint();

				} catch (Exception ex) {
					showError(ex.getMessage());
				}

			}
		});

	}

	private void initialize() {
		
		Group g = new Group(111, 14, 24, "Julian", "Rodríguez", "12345678J");
		g.setValid(true);
		modeloLista.addElement(g);
		g = new Group(112, 18, 76, "Amanda", "Domínguez", "12312378JM");
		g.setValid(true);
		modeloLista.addElement(g);
		g = new Group(167, 8, 12, "Roberto", "Martínez", "14523689W");
		g.setValid(true);
		modeloLista.addElement(g);

		list.setSelectedIndex(0);
		pnlRouteContraction.listGroup.setModel(list.getModel());
		
		g = (Group) modeloLista.getElementAt(list.getSelectedIndex());
		((pnlGroup) pnlForm).txtNombre.setText(g.getNombre());
		((pnlGroup) pnlForm).txtApellidos.setText(g.getApellidos());
		((pnlGroup) pnlForm).txtDNI.setText(g.getDNI());
		((pnlGroup) pnlForm).txtGroupID.setText(Integer.toString(g.getId()));
		((pnlGroup) pnlForm).Nmiembros.setValue(g.getNmiembros());
		((pnlGroup) pnlForm).txtEdad.setText(Integer.toString(g.getMediaEdad()));
		list.ensureIndexIsVisible(list.getSelectedIndex());
				
		list.ensureIndexIsVisible(list.getSelectedIndex());

	}
	
	public static DefaultListModel getModeloLista() {
		return modeloLista;
	}

	private void searchFilter(String searchTerm) {

		DefaultListModel filteredItems = new DefaultListModel();

		for (int i = 0; i < list.getModel().getSize(); i++) {

			Group g = (Group) list.getModel().getElementAt(i);
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
		String errorMessage = Messages.getString("pnlGroupManagement.35") + exceptionError.getMessage() + "\nStackTrace: " //$NON-NLS-1$ //$NON-NLS-2$
				+ Arrays.toString(exceptionError.getStackTrace());
		String title = exceptionError.getClass().getName();
		showError(errorMessage, title);
	}

	public static void showError(String errorMessage, String title) {
		JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);
	}

}
