package presentation;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Point;
import javax.swing.JSplitPane;
import javax.swing.ListModel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import presentation.pnlRouteManagement.TxtSearchMouseListener;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.ComponentOrientation;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlRouteContraction extends JPanel {
	protected static JList listGroup;
	protected static JList listRoute;
	protected DefaultListModel modeloListaRoute, modeloListaGroup;
	protected RoundJTextField txtSearchGroup, txtSearchRoute;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unchecked" })
	public pnlRouteContraction() {
		setPreferredSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));
		setMinimumSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));
		setMaximumSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitRenders = new JSplitPane();
		splitRenders.setBounds(new Rectangle(0, 0, 0, Main.getTamano(400)));
		splitRenders.setMaximumSize(new Dimension(Main.getTamano(400), Main.getTamano(250)));
		splitRenders.setMinimumSize(new Dimension(Main.getTamano(400), Main.getTamano(250)));
		splitRenders.setPreferredSize(new Dimension(Main.getTamano(400), Main.getTamano(250)));
		add(splitRenders, BorderLayout.NORTH);

		JPanel pnlRoute = new JPanel();
		pnlRoute.setBounds(new Rectangle(0, 0, Main.getTamano(300), Main.getTamano(400)));
		splitRenders.setLeftComponent(pnlRoute);
		pnlRoute.setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(new Rectangle(0, 0, Main.getTamano(300), Main.getTamano(20)));
		toolBar.setPreferredSize(new Dimension(Main.getTamano(300), Main.getTamano(24)));
		toolBar.setFloatable(false);
		pnlRoute.add(toolBar, BorderLayout.NORTH);

		JLabel lblRoute = new JLabel("");
		lblRoute.setToolTipText(Messages.getString("pnlRouteContraction.lblRoute.toolTipText")); //$NON-NLS-1$
		lblRoute.setIcon(new ImageIcon(pnlRouteContraction.class.getResource("/presentation/loupe.png")));
		toolBar.add(lblRoute);

		txtSearchRoute = new RoundJTextField(32);
		txtSearchRoute.setToolTipText(Messages.getString("pnlRouteContraction.txtSearchRoute.toolTipText")); //$NON-NLS-1$
		txtSearchRoute.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 8) {
					txtSearchRoute.setText("");
					listRoute.setModel(modeloListaRoute);
				} else {
					searchFilterRoute(txtSearchRoute.getText());
				}
			}
		});
		txtSearchRoute.addMouseListener(new TxtSearchMouseListenerRoute());
		txtSearchRoute.setColumns(10);
		toolBar.add(txtSearchRoute);

		JScrollPane scrollPaneRoute = new JScrollPane();
		scrollPaneRoute.setBounds(new Rectangle(0, 0, Main.getTamano(300), Main.getTamano(380)));
		scrollPaneRoute.setPreferredSize(new Dimension(Main.getTamano(300), Main.getTamano(200)));
		scrollPaneRoute.setMinimumSize(new Dimension(Main.getTamano(300), Main.getTamano(200)));
		scrollPaneRoute.setAutoscrolls(true);
		scrollPaneRoute.setAlignmentY(0.0f);
		scrollPaneRoute.setAlignmentX(0.0f);
		scrollPaneRoute.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneRoute.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlRoute.add(scrollPaneRoute, BorderLayout.SOUTH);

		listRoute = new JList();
		listRoute.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		listRoute.setAlignmentY(Component.TOP_ALIGNMENT);
		listRoute.setAlignmentX(Component.LEFT_ALIGNMENT);
		listRoute.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		modeloListaRoute = new DefaultListModel();

		listRoute.setModel(modeloListaRoute);
		listRoute.setCellRenderer(new NuestroCellRenderer());
		listRoute.repaint();
		scrollPaneRoute.setViewportView(listRoute);

		JPanel pnlGroup = new JPanel();
		pnlGroup.setBounds(new Rectangle(0, 0, Main.getTamano(300), Main.getTamano(400)));
		splitRenders.setRightComponent(pnlGroup);
		pnlGroup.setLayout(new BorderLayout(0, 0));

		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		toolBar_1.setBounds(new Rectangle(0, 0, Main.getTamano(300), Main.getTamano(20)));
		pnlGroup.add(toolBar_1, BorderLayout.NORTH);

		JLabel label = new JLabel("");
		label.setToolTipText(Messages.getString("pnlRouteContraction.label.toolTipText")); //$NON-NLS-1$
		label.setIcon(new ImageIcon(pnlRouteContraction.class.getResource("/presentation/loupe.png")));
		toolBar_1.add(label);

		txtSearchGroup = new RoundJTextField(32);
		txtSearchGroup.setToolTipText(Messages.getString("pnlRouteContraction.txtSearchGroup.toolTipText")); //$NON-NLS-1$
		txtSearchGroup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 8) {
					txtSearchGroup.setText("");
					listGroup.setModel(modeloListaGroup);
				} else {
					searchFilterGroup(txtSearchGroup.getText());
				}
			}
		});
		txtSearchGroup.addMouseListener(new TxtSearchMouseListenerGroup());
		txtSearchGroup.setColumns(10);
		toolBar_1.add(txtSearchGroup);

		JScrollPane scrollPaneGroup = new JScrollPane();
		scrollPaneGroup.setBounds(new Rectangle(0, 0, Main.getTamano(300), Main.getTamano(380)));
		scrollPaneGroup.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneGroup.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneGroup.setPreferredSize(new Dimension(Main.getTamano(300), Main.getTamano(200)));
		scrollPaneGroup.setMinimumSize(new Dimension(Main.getTamano(300), Main.getTamano(200)));
		scrollPaneGroup.setAutoscrolls(true);
		scrollPaneGroup.setAlignmentY(0.0f);
		scrollPaneGroup.setAlignmentX(0.0f);
		pnlGroup.add(scrollPaneGroup, BorderLayout.SOUTH);

		listGroup = new JList();
		listGroup.setAlignmentX(Component.LEFT_ALIGNMENT);
		listGroup.setAlignmentY(Component.TOP_ALIGNMENT);
		
		modeloListaGroup = new DefaultListModel();

		listGroup.setModel(modeloListaGroup);
		listGroup.setCellRenderer(new NuestroCellRenderer());
		listGroup.repaint();
		scrollPaneGroup.setViewportView(listGroup);
		splitRenders.setDividerLocation(Main.getTamano(420));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(Main.getTamano(400), Main.getTamano(250)));
		add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(50),  Main.getTamano(20),  Main.getTamano(40),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(50),  Main.getTamano(50),  Main.getTamano(40),  Main.getTamano(20),  Main.getTamano(40),  Main.getTamano(50),  Main.getTamano(50),  Main.getTamano(60),  Main.getTamano(50),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20),
				 Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20), 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] {  Main.getTamano(70),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(20),  Main.getTamano(23),  Main.getTamano(35), 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblFecha = new JLabel(Messages.getString("pnlRouteContraction.lblFecha.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0,  Main.getTamano(5), Main.getTamano(5));
		gbc_lblFecha.gridx = 11;
		gbc_lblFecha.gridy = 1;
		panel.add(lblFecha, gbc_lblFecha);

		JCalendar calendar = new JCalendar();
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.gridheight = 3;
		gbc_calendar.gridwidth = 6;
		gbc_calendar.insets = new Insets(0, 0, Main.getTamano(5),Main.getTamano(5));
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 11;
		gbc_calendar.gridy = 3;
		panel.add(calendar, gbc_calendar);
		
				JButton button = new JButton(Messages.getString("pnlRouteContraction.button.text")); //$NON-NLS-1$
				button.setToolTipText(Messages.getString("pnlRouteContraction.button.toolTipText")); //$NON-NLS-1$
				button.setIcon(new ImageIcon(pnlRouteContraction.class.getResource("/presentation/check-mark_16x16.png")));
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultListModel modeloHistory = pnlHistoryManagement.modeloLista;
						int indice = modeloHistory.getSize();
						Group g = (Group) listGroup.getModel().getElementAt(listGroup.getSelectedIndex());
						Route r = (Route) listRoute.getModel().getElementAt(listRoute.getSelectedIndex());
						Date d = calendar.getDate();
						RouteContraction c = new RouteContraction(r, g, (java.util.Date) d);
						modeloHistory.addElement(c);
						pnlHistoryManagement.list.setSelectedIndex(modeloHistory.getSize() - 1);
						pnlHistoryManagement.list.setModel(modeloHistory);
						pnlHistoryManagement.list.ensureIndexIsVisible(indice);
					}
				});
				button.setPreferredSize(new Dimension(Main.getTamano(75), Main.getTamano(23)));
				button.setMinimumSize(new Dimension(Main.getTamano(75), Main.getTamano(23)));
				button.setMaximumSize(new Dimension(Main.getTamano(75), Main.getTamano(23)));
				button.setFont(new Font("Verdana", Font.BOLD, Main.getTamano(13)));
				button.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				button.setBackground(new Color(144, 238, 144));
				GridBagConstraints gbc_button = new GridBagConstraints();
				gbc_button.fill = GridBagConstraints.HORIZONTAL;
				gbc_button.gridwidth = 3;
				gbc_button.insets = new Insets(0, 0, Main.getTamano(5),Main.getTamano(5));
				gbc_button.gridx = 12;
				gbc_button.gridy = 7;
				panel.add(button, gbc_button);

	}
	
	private void initialize() {
		
		listGroup.setModel(modeloListaGroup);
		listRoute.setModel(modeloListaRoute);
		listGroup.repaint();
		listRoute.repaint();

	}

	private void searchFilterGroup(String searchTerm) {

		DefaultListModel filteredItems = new DefaultListModel();

		for (int i = 0; i < listGroup.getModel().getSize(); i++) {

			Group g = (Group) listGroup.getModel().getElementAt(i);
			String name = g.getNombre().toLowerCase();
			if (name.startsWith(searchTerm.toLowerCase()))
				filteredItems.addElement(g);

		}
		listGroup.setModel(filteredItems);
	}

	public class TxtSearchMouseListenerGroup extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			txtSearchGroup.setText("");
		}
	}

	private void searchFilterRoute(String searchTerm) {

		DefaultListModel filteredItems = new DefaultListModel();

		for (int i = 0; i < listRoute.getModel().getSize(); i++) {

			Route g = (Route) listRoute.getModel().getElementAt(i);
			String name = g.getNombre().toLowerCase();
			if (name.startsWith(searchTerm.toLowerCase()))
				filteredItems.addElement(g);

		}
		listRoute.setModel(filteredItems);
	}

	public class TxtSearchMouseListenerRoute extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			txtSearchRoute.setText("");
		}
	}

}
