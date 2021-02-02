package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;

public class Help extends JFrame{

	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help window = new Help();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Help() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(new Rectangle(0, 0, Main.getTamano(1080), Main.getTamano(750)));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnlBusqueda = new JPanel();
		tabbedPane.addTab("B\u00FAsqueda", null, pnlBusqueda, null);
		pnlBusqueda.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Help.class.getResource("/presentation/help_search.PNG")));
		pnlBusqueda.add(label, BorderLayout.NORTH);
		
		JTextArea txtrElBuscadorPuede = new JTextArea();
		txtrElBuscadorPuede.setEditable(false);
		txtrElBuscadorPuede.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		txtrElBuscadorPuede.setText(Messages.getString("Help.txtrElBuscadorPuede.text")); //$NON-NLS-1$
		txtrElBuscadorPuede.setRows(10);
		pnlBusqueda.add(txtrElBuscadorPuede, BorderLayout.SOUTH);
		
		JPanel pnlAE = new JPanel();
		tabbedPane.addTab("A\u00F1adir / Eliminar", null, pnlAE, null);
		pnlAE.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Help.class.getResource("/presentation/help_add.PNG")));
		pnlAE.add(label_1, BorderLayout.NORTH);
		
		JTextArea txtrBotnAadirPulsando = new JTextArea();
		txtrBotnAadirPulsando.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		txtrBotnAadirPulsando.setEditable(false);
		txtrBotnAadirPulsando.setText(Messages.getString("Help.txtrBotnAadirPulsando.text")); //$NON-NLS-1$
		txtrBotnAadirPulsando.setRows(10);
		pnlAE.add(txtrBotnAadirPulsando, BorderLayout.SOUTH);
		
		JPanel pnlAceptar = new JPanel();
		tabbedPane.addTab("Aceptar", null, pnlAceptar, null);
		pnlAceptar.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Help.class.getResource("/presentation/help_accept.PNG")));
		pnlAceptar.add(label_2, BorderLayout.NORTH);
		
		JTextArea txtrPulsandoElBotn = new JTextArea();
		txtrPulsandoElBotn.setEditable(false);
		txtrPulsandoElBotn.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		txtrPulsandoElBotn.setText(Messages.getString("Help.txtrPulsandoElBotn.text")); //$NON-NLS-1$
		txtrPulsandoElBotn.setRows(10);
		pnlAceptar.add(txtrPulsandoElBotn, BorderLayout.SOUTH);
		
		JPanel pnlErrores = new JPanel();
		tabbedPane.addTab("Errores", null, pnlErrores, null);
		pnlErrores.setLayout(new BorderLayout(0, 0));
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Help.class.getResource("/presentation/help_error.PNG")));
		pnlErrores.add(label_3, BorderLayout.NORTH);
		
		JTextArea txtrErrorProvocado = new JTextArea();
		txtrErrorProvocado.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		txtrErrorProvocado.setEditable(false);
		txtrErrorProvocado.setText(Messages.getString("Help.txtrErrorProvocado.text")); //$NON-NLS-1$
		pnlErrores.add(txtrErrorProvocado, BorderLayout.CENTER);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
