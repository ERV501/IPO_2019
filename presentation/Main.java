package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;

public class Main {

	protected JFrame frmGuasTursticas;
	private JTabbedPane tabbedPane;
	private JPanel pnlGuideManagement;
	private JPanel pnlGroupManagement;
	private JPanel pnlRouteManagement;
	private JPanel pnlRouteContraction;
	private JPanel pnlHistory;
	private JMenuBar menuBar;
	private JMenu mnAyuda;
	private JMenu mnIdioma;
	private JMenu mnTamao;
	private JMenuItem mntmAyuda;
	private JRadioButtonMenuItem rdbtnmntmPequeo;
	private JRadioButtonMenuItem rdbtnmntmNormal;
	private JRadioButtonMenuItem rdbtnmntmGrande;
	private JRadioButtonMenuItem rdbtnmntmEspaol;
	private JRadioButtonMenuItem rdbtnmntmIngls;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JSplitPane splitPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblUser;
	private JLabel lblDate;
	protected static String tamano;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main("español", "normal", "admin");
					window.frmGuasTursticas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main(String idioma, String tamano, String user) {
		initialize(idioma, tamano, user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String idioma, String tamano, String user) {
		this.tamano = tamano;
		frmGuasTursticas = new JFrame();
		Messages.setIdioma(idioma);
		frmGuasTursticas.setResizable(false);
		frmGuasTursticas.setTitle(Messages.getString("Main.frmGuasTursticas.title")); //$NON-NLS-1$
		frmGuasTursticas.setSize(new Dimension(Main.getTamano(1000), Main.getTamano(600)));
		frmGuasTursticas.setLocationRelativeTo(null);
		frmGuasTursticas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frmGuasTursticas.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		mnAyuda = new JMenu(Messages.getString("Main.mnAyuda.text")); //$NON-NLS-1$
		menuBar.add(mnAyuda);
		
		mntmAyuda = new JMenuItem(Messages.getString("Main.mntmAyuda.text")); //$NON-NLS-1$
		mntmAyuda.setIcon(new ImageIcon(Main.class.getResource("/presentation/info.png"))); //$NON-NLS-1$
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help h = new Help();
				h.frame.setVisible(true);
			}
		});
		mnAyuda.add(mntmAyuda);
		
		mnIdioma = new JMenu(Messages.getString("Main.mnIdioma.text")); //$NON-NLS-1$
		menuBar.add(mnIdioma);
		
		rdbtnmntmEspaol = new JRadioButtonMenuItem(Messages.getString("Main.rdbtnmntmEspaol.text")); //$NON-NLS-1$
		rdbtnmntmEspaol.setIcon(new ImageIcon(Main.class.getResource("/presentation/spain.png")));
		rdbtnmntmEspaol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultListModel modeloListaGuide = ((presentation.pnlGuideManagement) pnlGuideManagement).getModeloLista();
				DefaultListModel modeloListaGroup = ((presentation.pnlGroupManagement) pnlGroupManagement).getModeloLista();
				DefaultListModel modeloListaRoute = ((presentation.pnlRouteManagement) pnlRouteManagement).getModeloLista();
				DefaultListModel modeloListaHistory = ((presentation.pnlHistoryManagement) pnlHistory).getModeloLista();
				
				Main m = new Main("español",tamano,user);
				
				m.frmGuasTursticas.setVisible(true);

				int size = modeloListaGuide.getSize();
				Guide g = null;
						
				for(int i=3; i< size; i++) {
					g = (Guide) modeloListaGuide.elementAt(i);
					if(g != null)
						((presentation.pnlGuideManagement) m.pnlGuideManagement).getModeloLista().addElement(g);
					
				}
				
				size = modeloListaGroup.getSize();	
				Group gr = null;
				
				for(int i=3; i< size; i++) {	
					gr = (Group) modeloListaGroup.elementAt(i);
					if(gr != null)
						((presentation.pnlGroupManagement) m.pnlGroupManagement).getModeloLista().addElement(gr);				
				}
				
				size = modeloListaRoute.getSize();	
				Route r = null;
				
				for(int i=3; i< size; i++) {	
					r = (Route) modeloListaRoute.elementAt(i);
					if(r != null)
						((presentation.pnlRouteManagement) m.pnlRouteManagement).getModeloLista().addElement(r);				
				}
				
				size = modeloListaHistory.getSize();	
				RouteContraction rc = null;
				
				for(int i=3; i< size; i++) {	
					rc = (RouteContraction) modeloListaHistory.elementAt(i);
					if(rc != null)
						((presentation.pnlHistoryManagement) m.pnlHistory).getModeloLista().addElement(gr);				
				}
				frmGuasTursticas.dispose();
				
			}
		});
		buttonGroup.add(rdbtnmntmEspaol);
		mnIdioma.add(rdbtnmntmEspaol);
		
		rdbtnmntmIngls = new JRadioButtonMenuItem(Messages.getString("Main.rdbtnmntmIngls.text")); //$NON-NLS-1$
		rdbtnmntmIngls.setIcon(new ImageIcon(Main.class.getResource("/presentation/united-kingdom.png")));
		rdbtnmntmIngls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel modeloListaGuide = ((presentation.pnlGuideManagement) pnlGuideManagement).getModeloLista();
				DefaultListModel modeloListaGroup = ((presentation.pnlGroupManagement) pnlGroupManagement).getModeloLista();
				DefaultListModel modeloListaRoute = ((presentation.pnlRouteManagement) pnlRouteManagement).getModeloLista();
				DefaultListModel modeloListaHistory = ((presentation.pnlHistoryManagement) pnlHistory).getModeloLista();
				
				Main m = new Main("inglés",tamano,user);
				
				m.frmGuasTursticas.setVisible(true);

				int size = modeloListaGuide.getSize();
				Guide g = null;
						
				for(int i=3; i< size; i++) {
					g = (Guide) modeloListaGuide.elementAt(i);
					if(g != null)
						((presentation.pnlGuideManagement) m.pnlGuideManagement).getModeloLista().addElement(g);
					
				}
				
				size = modeloListaGroup.getSize();	
				Group gr = null;
				
				for(int i=3; i< size; i++) {	
					gr = (Group) modeloListaGroup.elementAt(i);
					if(gr != null)
						((presentation.pnlGroupManagement) m.pnlGroupManagement).getModeloLista().addElement(gr);				
				}
				
				size = modeloListaRoute.getSize();	
				Route r = null;
				
				for(int i=3; i< size; i++) {	
					r = (Route) modeloListaRoute.elementAt(i);
					if(r != null)
						((presentation.pnlRouteManagement) m.pnlRouteManagement).getModeloLista().addElement(r);				
				}
				
				size = modeloListaHistory.getSize();	
				RouteContraction rc = null;
				
				for(int i=3; i< size; i++) {	
					rc = (RouteContraction) modeloListaHistory.elementAt(i);
					if(rc != null)
						((presentation.pnlHistoryManagement) m.pnlHistory).getModeloLista().addElement(gr);				
				}
				frmGuasTursticas.dispose();
			}
		});
		buttonGroup.add(rdbtnmntmIngls);
		mnIdioma.add(rdbtnmntmIngls);
		
		mnTamao = new JMenu(Messages.getString("Main.mnTamao.text")); //$NON-NLS-1$
		menuBar.add(mnTamao);
		
		rdbtnmntmPequeo = new JRadioButtonMenuItem(Messages.getString("Main.rdbtnmntmPequeo.text")); //$NON-NLS-1$
		rdbtnmntmPequeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultListModel modeloListaGuide = ((presentation.pnlGuideManagement) pnlGuideManagement).getModeloLista();
				DefaultListModel modeloListaGroup = ((presentation.pnlGroupManagement) pnlGroupManagement).getModeloLista();
				DefaultListModel modeloListaRoute = ((presentation.pnlRouteManagement) pnlRouteManagement).getModeloLista();
				DefaultListModel modeloListaHistory = ((presentation.pnlHistoryManagement) pnlHistory).getModeloLista();
				
				Main m = new Main(idioma,"pequeño",user);
				
				m.frmGuasTursticas.setVisible(true);

				int size = modeloListaGuide.getSize();
				Guide g = null;
						
				for(int i=3; i< size; i++) {
					g = (Guide) modeloListaGuide.elementAt(i);
					if(g != null)
						((presentation.pnlGuideManagement) m.pnlGuideManagement).getModeloLista().addElement(g);
					
				}
				
				size = modeloListaGroup.getSize();	
				Group gr = null;
				
				for(int i=3; i< size; i++) {	
					gr = (Group) modeloListaGroup.elementAt(i);
					if(gr != null)
						((presentation.pnlGroupManagement) m.pnlGroupManagement).getModeloLista().addElement(gr);				
				}
				
				size = modeloListaRoute.getSize();	
				Route r = null;
				
				for(int i=3; i< size; i++) {	
					r = (Route) modeloListaRoute.elementAt(i);
					if(r != null)
						((presentation.pnlRouteManagement) m.pnlRouteManagement).getModeloLista().addElement(r);				
				}
				
				size = modeloListaHistory.getSize();	
				RouteContraction rc = null;
				
				for(int i=3; i< size; i++) {	
					rc = (RouteContraction) modeloListaHistory.elementAt(i);
					if(rc != null)
						((presentation.pnlHistoryManagement) m.pnlHistory).getModeloLista().addElement(gr);				
				}
				frmGuasTursticas.dispose();
			}
		});
		buttonGroup_1.add(rdbtnmntmPequeo);
		mnTamao.add(rdbtnmntmPequeo);
		
		rdbtnmntmNormal = new JRadioButtonMenuItem(Messages.getString("Main.rdbtnmntmNormal.text")); //$NON-NLS-1$
		rdbtnmntmNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultListModel modeloListaGuide = ((presentation.pnlGuideManagement) pnlGuideManagement).getModeloLista();
				DefaultListModel modeloListaGroup = ((presentation.pnlGroupManagement) pnlGroupManagement).getModeloLista();
				DefaultListModel modeloListaRoute = ((presentation.pnlRouteManagement) pnlRouteManagement).getModeloLista();
				DefaultListModel modeloListaHistory = ((presentation.pnlHistoryManagement) pnlHistory).getModeloLista();
				
				Main m = new Main(idioma,"normal",user);
				
				m.frmGuasTursticas.setVisible(true);

				int size = modeloListaGuide.getSize();
				Guide g = null;
						
				for(int i=3; i< size; i++) {
					g = (Guide) modeloListaGuide.elementAt(i);
					if(g != null)
						((presentation.pnlGuideManagement) m.pnlGuideManagement).getModeloLista().addElement(g);
					
				}
				
				size = modeloListaGroup.getSize();	
				Group gr = null;
				
				for(int i=3; i< size; i++) {	
					gr = (Group) modeloListaGroup.elementAt(i);
					if(gr != null)
						((presentation.pnlGroupManagement) m.pnlGroupManagement).getModeloLista().addElement(gr);				
				}
				
				size = modeloListaRoute.getSize();	
				Route r = null;
				
				for(int i=3; i< size; i++) {	
					r = (Route) modeloListaRoute.elementAt(i);
					if(r != null)
						((presentation.pnlRouteManagement) m.pnlRouteManagement).getModeloLista().addElement(r);				
				}
				
				size = modeloListaHistory.getSize();	
				RouteContraction rc = null;
				
				for(int i=3; i< size; i++) {	
					rc = (RouteContraction) modeloListaHistory.elementAt(i);
					if(rc != null)
						((presentation.pnlHistoryManagement) m.pnlHistory).getModeloLista().addElement(gr);				
				}
				frmGuasTursticas.dispose();
			}
		});
		buttonGroup_1.add(rdbtnmntmNormal);
		mnTamao.add(rdbtnmntmNormal);
		
		rdbtnmntmGrande = new JRadioButtonMenuItem(Messages.getString("Main.rdbtnmntmGrande.text")); //$NON-NLS-1$
		rdbtnmntmGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultListModel modeloListaGuide = ((presentation.pnlGuideManagement) pnlGuideManagement).getModeloLista();
				DefaultListModel modeloListaGroup = ((presentation.pnlGroupManagement) pnlGroupManagement).getModeloLista();
				DefaultListModel modeloListaRoute = ((presentation.pnlRouteManagement) pnlRouteManagement).getModeloLista();
				DefaultListModel modeloListaHistory = ((presentation.pnlHistoryManagement) pnlHistory).getModeloLista();
				
				Main m = new Main(idioma,"grande",user);
				
				m.frmGuasTursticas.setVisible(true);

				int size = modeloListaGuide.getSize();
				Guide g = null;
						
				for(int i=3; i< size; i++) {
					g = (Guide) modeloListaGuide.elementAt(i);
					if(g != null)
						((presentation.pnlGuideManagement) m.pnlGuideManagement).getModeloLista().addElement(g);
					
				}
				
				size = modeloListaGroup.getSize();	
				Group gr = null;
				
				for(int i=3; i< size; i++) {	
					gr = (Group) modeloListaGroup.elementAt(i);
					if(gr != null)
						((presentation.pnlGroupManagement) m.pnlGroupManagement).getModeloLista().addElement(gr);				
				}
				
				size = modeloListaRoute.getSize();	
				Route r = null;
				
				for(int i=3; i< size; i++) {	
					r = (Route) modeloListaRoute.elementAt(i);
					if(r != null)
						((presentation.pnlRouteManagement) m.pnlRouteManagement).getModeloLista().addElement(r);				
				}
				
				size = modeloListaHistory.getSize();	
				RouteContraction rc = null;
				
				for(int i=3; i< size; i++) {	
					rc = (RouteContraction) modeloListaHistory.elementAt(i);
					if(rc != null)
						((presentation.pnlHistoryManagement) m.pnlHistory).getModeloLista().addElement(gr);				
				}
				frmGuasTursticas.dispose();
			}
		});
		buttonGroup_1.add(rdbtnmntmGrande);
		mnTamao.add(rdbtnmntmGrande);
		
		buttonGroup.clearSelection();
		if(idioma == "español")
			rdbtnmntmEspaol.setSelected(true);
		if(idioma == "inglés")
			rdbtnmntmIngls.setSelected(true);
		buttonGroup_1.clearSelection();
		if(tamano == "pequeño")
			rdbtnmntmPequeo.setSelected(true);
		if(tamano == "normal")
			rdbtnmntmNormal.setSelected(true);
		if(tamano == "grande")
			rdbtnmntmGrande.setSelected(true);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		frmGuasTursticas.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		pnlRouteContraction = new pnlRouteContraction();
		pnlGuideManagement = new pnlGuideManagement();
		pnlGroupManagement = new pnlGroupManagement();
		pnlRouteManagement = new pnlRouteManagement();
		pnlHistory = new pnlHistoryManagement();
		
		tabbedPane.addTab(Messages.getString("Main.3"), null, pnlGuideManagement, null); //$NON-NLS-1$
		tabbedPane.addTab(Messages.getString("Main.2"), null, pnlGroupManagement, null); //$NON-NLS-1$
		tabbedPane.addTab(Messages.getString("Main.1"), null, pnlRouteManagement, null); //$NON-NLS-1$
		tabbedPane.addTab(Messages.getString("Main.0"), null, pnlRouteContraction, null); //$NON-NLS-1$
		tabbedPane.addTab(Messages.getString("Main.7"), null, pnlHistory, null);
		
		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		frmGuasTursticas.getContentPane().add(splitPane, BorderLayout.SOUTH);
		
		panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblUser = new JLabel(Messages.getString("Main.lblUser.text")); //$NON-NLS-1$
		lblUser.setIcon(new ImageIcon(Main.class.getResource("/presentation/man-user.png")));
		lblUser.setEnabled(false);
		panel.add(lblUser, BorderLayout.WEST);
		
		lblUser.setText(user);
		
		panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblDate = new JLabel(Messages.getString("Main.lblDate.text")); //$NON-NLS-1$
		lblDate.setEnabled(false);
		panel_1.add(lblDate, BorderLayout.EAST);
		
		Date d = new Date();
		
		lblDate.setText(d.toString());
	}
	
	public void setVisible(boolean b) {
		this.frmGuasTursticas.setVisible(true);
		
	}
	
	public static void setTamano(String t) {
		tamano = t;
	}
	
	public static String getTamano() {
		return tamano;
	}
	
	public static int getTamano(int st) {
		int s = (int) (st*1.25);
		int b = (int) (st*1.5);
		if(Main.getTamano() == "pequeño") {
			return st;
		}
		else if(Main.getTamano() == "normal") {
			return s;
		}
		else {
			return b;
		}
	}
	
}
