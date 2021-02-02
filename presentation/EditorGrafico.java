package presentation;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class EditorGrafico extends JFrame{
	int modo = -1;
	private final int PUNTO = 1;
	private final int RECTA = 2;
	private final int TEXTO = 4;

	JFrame frame;
	private JToolBar toolBar;
	private JButton buttonSave;
	private JButton buttonPunto;
	private JButton buttonRecta;
	private JScrollPane scrollPane;
	private MiAreaDibujo miAreaDibujo;
	private ImageIcon imagen;
     
	private Toolkit toolkit;
	private Image imagPunto;
	private Image imagRecta;
	private Image imagCursorPunto;
	private Cursor cursorPunto;
	private Cursor cursorRecta;
	private int x;
	private int y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorGrafico window = new EditorGrafico();
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
	public EditorGrafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, Main.getTamano(450), Main.getTamano(350)));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		toolkit = Toolkit.getDefaultToolkit();
		imagPunto = toolkit.getImage(getClass().getClassLoader().getResource("presentation/pin.png"));
		imagRecta = toolkit.getImage(getClass().getClassLoader().getResource("presentation/editar.png"));
		imagCursorPunto = toolkit.getImage(getClass().getClassLoader().getResource("presentation/mapas-y-banderas.png"));

		// Creación de los cursores
		cursorRecta = toolkit.createCustomCursor(imagRecta, new Point(0, 0), "CURSOR_RECTANGULO");
		cursorPunto = toolkit.createCustomCursor(imagCursorPunto, new Point(0, 0), "CURSOR_SOL");

		buttonSave = new JButton("");
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Route r = (Route) pnlRouteManagement.modeloLista.getElementAt(pnlRouteManagement.list.getSelectedIndex());
				ImageIcon image = (ImageIcon) miAreaDibujo.getIcon();
				r.setImage(image);
				pnlRouteManagement.pnlForm.lblMapa.setIcon(image);
				frame.dispose();
			}
		});
		buttonSave.setToolTipText(Messages.getString("EditorGrafico.buttonSave.toolTipText")); //$NON-NLS-1$
		buttonSave.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentation/guardar-el-archivo.png")));
		toolBar.add(buttonSave);

		buttonPunto = new JButton("");
		buttonPunto.setToolTipText(Messages.getString("EditorGrafico.buttonPunto.toolTipText")); //$NON-NLS-1$
		buttonPunto.addActionListener(new ButtonSoleadoActionListener());
		buttonPunto.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentation/direccion.png")));
		toolBar.add(buttonPunto);

		buttonRecta = new JButton("");
		buttonRecta.setToolTipText(Messages.getString("EditorGrafico.buttonRecta.toolTipText")); //$NON-NLS-1$
		buttonRecta.addActionListener(new ButtonRectanguloActionListener());
		buttonRecta.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentation/lapiz.png")));
		toolBar.add(buttonRecta);

		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		miAreaDibujo = new MiAreaDibujo();
		miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
		miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
		miAreaDibujo.setIcon(null);
		scrollPane.setViewportView(miAreaDibujo);
		
		Route r = (Route) pnlRouteManagement.modeloLista.getElementAt(pnlRouteManagement.list.getSelectedIndex());
		
		imagen = r.getImage();
		miAreaDibujo.setIcon(imagen);

	}




	private class ButtonSoleadoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = PUNTO;
			frame.setCursor(cursorPunto);
		}
	}

	private class ButtonRectanguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = RECTA;
			frame.setCursor(cursorRecta);
		}
	}

	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if (imagen != null) {
				switch (modo) {
				case PUNTO:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagPunto));
					miAreaDibujo.repaint();
					break;
				case RECTA:
					miAreaDibujo.addObjetoGrafico(new RectaGrafico(x, y, x, y, Color.RED));
					break;
				}
			}
		}

	}

	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {

		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == RECTA && imagen != null) {
				((RectaGrafico) miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((RectaGrafico) miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
			}
		}
	}
}
