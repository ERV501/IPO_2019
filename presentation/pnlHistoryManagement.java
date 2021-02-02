package presentation;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class pnlHistoryManagement extends JPanel {
	
	protected JSplitPane splitPane;
	private JPanel pnlSearch;
	private JToolBar toolBar;
	private JTextField txtSearch;
	private JLabel lblSearch;
	private JPanel panel;
	static JList list;
	static DefaultListModel modeloLista;
	private JScrollPane scrollPane;
	private pnlHistory pnlForm;

	/**
	 * Create the panel.
	 */
	public pnlHistoryManagement() {
		
		setSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));
		
		splitPane = new JSplitPane();
		splitPane.setSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));
		splitPane.setPreferredSize(new Dimension(Main.getTamano(800), Main.getTamano(500)));
		add(splitPane);
		
		pnlSearch = new JPanel();
		pnlSearch.setSize(new Dimension(Main.getTamano(300), 0));
		pnlSearch.setPreferredSize(new Dimension(Main.getTamano(300), Main.getTamano(500)));
		pnlSearch.setMinimumSize(new Dimension(Main.getTamano(300), Main.getTamano(500)));
		pnlSearch.setMaximumSize(new Dimension(Main.getTamano(300), 32767));
		pnlSearch.setLayout(new BorderLayout(0, 0));
		splitPane.setLeftComponent(pnlSearch);
		
		panel = new JPanel();
		pnlSearch.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		toolBar = new JToolBar();
		toolBar.setPreferredSize(new Dimension(Main.getTamano(300), Main.getTamano(24)));
		toolBar.setFloatable(false);
		panel.add(toolBar, BorderLayout.NORTH);
		
		lblSearch = new JLabel("");
		lblSearch.setToolTipText(Messages.getString("pnlHistoryManagement.lblSearch.toolTipText")); //$NON-NLS-1$
		lblSearch.setIcon(new ImageIcon(Main.class.getResource("/presentation/loupe.png")));
		toolBar.add(lblSearch);
		
		txtSearch = new RoundJTextField(32);
		txtSearch.setToolTipText(Messages.getString("pnlHistoryManagement.txtSearch.toolTipText")); //$NON-NLS-1$
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==8) {
					txtSearch.setText("");
					list.setModel(modeloLista);
				}
				else {
					searchFilter(txtSearch.getText());
				}
			}
		});
		txtSearch.addMouseListener(new TxtSearchMouseListener());
		toolBar.add(txtSearch);
		txtSearch.setColumns(10);
		
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
			String[] values = new String[] {""};
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
		
		list.setCellRenderer(new NuestroCellRenderer2());
		
		pnlForm = new pnlHistory();
		
		splitPane.setRightComponent(pnlForm);
		
		initialize();
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (list.getSelectedIndex() != -1) {
					
					RouteContraction g = (RouteContraction) modeloLista.getElementAt(list.getSelectedIndex());
					
					Route r = g.getR();
					Group gr = g.getG();
					Date d = g.getD();
					
					((pnlHistory) pnlForm).textIdRuta.setText(Integer.toString(r.getID()));
					((pnlHistory) pnlForm).txtNombreruta.setText(r.getNombre());
					((pnlHistory) pnlForm).txtLongitud.setText(Float.toString(r.getLongitud()));
					((pnlHistory) pnlForm).txtIdGrupo.setText(Integer.toString(gr.getId()));
					((pnlHistory) pnlForm).txtIdLider.setText(gr.getDNI());
					((pnlHistory) pnlForm).txtFechacontratacion.setText(d.toString());
					((pnlHistory) pnlForm).txtMiembros.setText(Integer.toString(gr.getNmiembros()));
					((pnlHistory) pnlForm).txtSalida.setText(r.getSalida().toString());
					((pnlHistory) pnlForm).txtLlegada.setText(r.getLlegada().toString());
					
					list.ensureIndexIsVisible(list.getSelectedIndex());
				}
			}
		});
		
	}
	
	private void initialize() {
		
		Route r1 = new Route(111, "La Vieja", (float) 126.6 , Route.Ciudades.Alcazar, Route.Ciudades.Bolaños);
		Route r2 = new Route(111, "La Templaria", (float) 41.2 , Route.Ciudades.Daimiel, Route.Ciudades.Valdepeñas);
		Route r3 = new Route(111, "La Revoltosa", (float) 24.1 , Route.Ciudades.Capital, Route.Ciudades.Almagro);
		
		Group g1 = new Group(111, 14, 24, "Julian", "Rodríguez", "12345678J");
		Group g2 = new Group(112, 18, 76, "Amanda", "Domínguez", "12312378JM");
		Group g3 = new Group(167, 8, 12, "Roberto", "Martínez", "14523689W");
		
		Date d1 = new Date(2019,11,28);
		Date d2 = new Date(2019,12,27);
		Date d3 = new Date(2019,12,8);
		
		RouteContraction c = new RouteContraction(r1,g2,d3);
		modeloLista.addElement(c);
		c = new RouteContraction(r2,g3,d1);
		modeloLista.addElement(c);
		c = new RouteContraction(r3,g1,d2);
		modeloLista.addElement(c);
		
		list.setSelectedIndex(0);
		
		RouteContraction g = (RouteContraction) modeloLista.getElementAt(list.getSelectedIndex());
		
		Route r = g.getR();
		Group gr = g.getG();
		Date d = g.getD();
		
		((pnlHistory) pnlForm).textIdRuta.setText(Integer.toString(r.getID()));
		((pnlHistory) pnlForm).txtNombreruta.setText(r.getNombre());
		((pnlHistory) pnlForm).txtLongitud.setText(Float.toString(r.getLongitud()));
		((pnlHistory) pnlForm).txtIdGrupo.setText(Integer.toString(gr.getId()));
		((pnlHistory) pnlForm).txtIdLider.setText(gr.getDNI());
		((pnlHistory) pnlForm).txtFechacontratacion.setText(d.toString());
		((pnlHistory) pnlForm).txtMiembros.setText(Integer.toString(gr.getNmiembros()));
		((pnlHistory) pnlForm).txtSalida.setText(r.getSalida().toString());
		((pnlHistory) pnlForm).txtLlegada.setText(r.getLlegada().toString());
		
		list.ensureIndexIsVisible(list.getSelectedIndex());
		
		list.ensureIndexIsVisible(list.getSelectedIndex());

	}
	
	public static DefaultListModel getModeloLista() {
		return modeloLista;
	}
	
	private void searchFilter(String searchTerm) {
		
		DefaultListModel filteredItems = new DefaultListModel();
		
		for(int i = 0; i<list.getModel().getSize();i++) {
			
			RouteContraction g = (RouteContraction) list.getModel().getElementAt(i);
			String name = g.getR().getNombre().toLowerCase();
			if(name.startsWith(searchTerm.toLowerCase()))
				filteredItems.addElement(g);
			
		}
		list.setModel(filteredItems);
	}
	
	public class TxtSearchMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			txtSearch.setText("");
		}
	}
	
	public static void showError(String errorMessage) {
		showError(errorMessage, "Error!");
	}

	public static void showError(Exception exceptionError) {
		String errorMessage = "Message: " + exceptionError.getMessage() + "\nStackTrace: "
				+ Arrays.toString(exceptionError.getStackTrace());
		String title = exceptionError.getClass().getName();
		showError(errorMessage, title);
	}

	public static void showError(String errorMessage, String title) {
		JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);
	}

}
